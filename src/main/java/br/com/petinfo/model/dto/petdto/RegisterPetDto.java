package br.com.petinfo.model.dto.petdto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public record RegisterPetDto(
        @NotBlank
        String name,
        SpeciesEnum species,
        GenderEnum gender,
        String race,
        String weight,
        String birthday
) {
        public LocalDate getDate() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                try {
                        return LocalDate.parse(birthday, formatter);
                } catch (DateTimeParseException e) {
                        throw new RuntimeException("Data inválida: " + birthday, e);
                }
        }
}
