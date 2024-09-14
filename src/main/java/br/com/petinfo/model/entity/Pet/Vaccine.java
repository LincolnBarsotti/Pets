package br.com.petinfo.model.entity.Pet;

import br.com.petinfo.model.dto.petdto.VaccineDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Lincoln
 */
@Data
@Entity
@Table(name = "vaccine")
public class Vaccine {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String idVaccine;

    private String nameVaccine;

    private String nameWhoRegisteredVaccine;

    private LocalDate registrationDateVaccine;

    private String vaccineFunction;

    private String vaccineBatch;

    private String vaccineManufacturer;

    @ManyToMany(mappedBy = "vaccines")
    @JsonIgnore
    private Set<Pet> pets;

    public Vaccine(VaccineDTO vaccineDTO) {
        this.nameVaccine = vaccineDTO.nameVaccine();
        this.vaccineBatch = vaccineDTO.vaccineBatch();
        this.vaccineManufacturer = vaccineDTO.vaccineManufacturer();
        this.vaccineFunction = vaccineDTO.vaccineFunction();
        this.registrationDateVaccine = vaccineDTO.registrationDateVacinne();
        this.nameWhoRegisteredVaccine = vaccineDTO.nameWhoRegisteredVaccine();
    }

    public Vaccine(){}

}