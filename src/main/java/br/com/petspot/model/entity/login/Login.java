package br.com.petspot.model.entity.login;

import br.com.petspot.model.dto.logindto.TypesUsers;
import br.com.petspot.model.entity.petOwner.PetOwner;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import br.com.petspot.model.dto.logindto.RegisterUserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author Lincoln
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "email"})
@Entity(name = "Login")
@Table(name = "login")
public class Login implements UserDetails {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @Email
    private String email;

    private String passwordLogin;

    private String typeOfUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_owner_id")
    private PetOwner petOwner;

    public Login(RegisterUserDto registerUserDto, String passwordLogin) {
        this.email = registerUserDto.email();
        this.passwordLogin = passwordLogin;
        this.typeOfUser = TypesUsers.PETOWNER.name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (typeOfUser.equalsIgnoreCase("PETOWNER")){
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return null;
    }

    @Override
    public String getPassword() {
        return this.passwordLogin;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
