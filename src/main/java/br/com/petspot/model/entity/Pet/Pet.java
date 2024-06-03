package br.com.petspot.model.entity.Pet;

import br.com.petspot.model.dto.petdto.RegisterPetDto;
import br.com.petspot.model.entity.petOwner.PetOwner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private Date petBirthday;

    private String specie;

    private String race;

    private Integer gender;

    @JsonIgnore
    @ManyToMany(mappedBy = "pet")
    private Set<PetOwner> petOwners = new HashSet<>();

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return dateFormat.format(this.petBirthday);
    }

}
