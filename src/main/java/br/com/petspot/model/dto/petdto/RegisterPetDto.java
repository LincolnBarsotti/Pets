package br.com.petspot.model.dto.petdto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
                        throw new RuntimeException("Data de aniversário inválida: " + birthday, e);
                }
        }
}
