package br.com.petinfo.model.dto.petdto;

import java.time.LocalDate;

/**
 * @author Lincoln
 */
public record VaccineDTO(
        String nameVaccine,
        String nameWhoRegisteredVaccine,
        LocalDate registrationDateVacinne,
        String vaccineFunction,
        String vaccineBatch,
        String vaccineManufacturer
) {

}
