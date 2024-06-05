package br.com.petspot.model.dto.petdto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        public Date getDate() {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

                try {
                        return format.parse(birthday);
                } catch (ParseException e) {
                        throw new RuntimeException(e);
                }
        }
}
