package br.com.petspot.model.entity.tutors;

import br.com.petspot.model.dto.logindto.RegisterUserDto;
import br.com.petspot.model.entity.login.Login;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "pet_owner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id_pet_owner"})
public class PetOwner {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id_pet_owner;

    @OneToOne(mappedBy = "petOwner")
    private Person person;

}
