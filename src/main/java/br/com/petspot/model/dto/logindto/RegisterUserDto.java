package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record RegisterUserDto(
        @Email
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+{}|;':\"/.,<>?])[a-zA-Z0-9~!@#$%^&*()_+{}|;':\"/.,<>?]+$"
        , message = "Password without pattern!")
        String password,
        @NotBlank
        @Size(min = 2, max = 18)
        String name,
        @NotBlank
        @Size(min = 2, max = 18)
        String surname,
        @NotBlank
        String birthday
) {

     public LocalDate getDate() {
         return LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
}
