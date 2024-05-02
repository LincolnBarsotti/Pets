package br.com.petspot.model.petOwner;

import br.com.petspot.dto.registerDto.RegisterDto;
import br.com.petspot.model.login.Login;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

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

    public PetOwner(RegisterDto registerDto) {
        this.name = registerDto.nome();
        this.lastName = registerDto.sobrenome();
        this.birthday = registerDto.getDate();
    }
}
