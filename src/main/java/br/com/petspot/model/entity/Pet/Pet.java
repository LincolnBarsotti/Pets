package br.com.petspot.model.entity.Pet;

import br.com.petspot.model.dto.petdto.RegisterPetDto;
import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.entity.tutors.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "pet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Pet {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    private String petName;

    private String petWeight;

    private LocalDate petBirthday;

    private String specie;

    private String race;

    private Integer gender;

    @JsonIgnore
    @ManyToMany(mappedBy = "pet")
    private Set<Person> person = new HashSet<>();

    public Pet(RegisterPetDto petDto) {
        this.petName = petDto.name();

        this.specie = petDto.species().name();

        if (petDto.gender() != null) {
            this.gender = petDto.gender().getValue();
        }
        if (petDto.birthday() != null) {
            this.petBirthday = petDto.getDate();
        }
        if (petDto.weight() != null) {
            this.petWeight = petDto.weight();
        }
        if (petDto.race() != null) {
            this.race = petDto.race();
        }
    }

    public String getPetBirthday() {
        return petBirthday.toString();
    }

    public int getAgeInYears() {
        if (this.petBirthday == null) {
            return 0;
        }
        return Period.between(petBirthday, LocalDate.now()).getYears();
    }

}
// Vou mija e ja volto