package br.com.petspot.model.entity.petOwner;

import br.com.petspot.model.dto.logindto.RegisterUserDto;
import br.com.petspot.model.entity.Pet.Pet;
import br.com.petspot.model.entity.login.Login;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pet_owner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class PetOwner {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    private String name;

    private String lastName;

    private Date birthday;

    @OneToOne(mappedBy = "petOwner")
    private Login login;

    @ManyToMany
    @JoinTable(name = "pets_client_tutor",
    joinColumns = @JoinColumn(name = "pet_owner_id"),
    inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private Set<Pet> pet = new HashSet<>();

    public PetOwner(RegisterUserDto registerUserDto) {
        this.name = registerUserDto.nome();
        this.lastName = registerUserDto.sobrenome();
        this.birthday = registerUserDto.getDate();
    }
}
