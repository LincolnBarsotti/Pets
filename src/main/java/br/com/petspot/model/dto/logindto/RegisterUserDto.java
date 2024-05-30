package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                @Size(min = 9, max = 9, message = "Date must contain 9 characters")
        String birthday
) {

     public Date getDate() {
         SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");  // Input format
         SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");  // Output format
            try {
                Date date = inputFormatter.parse(birthday);
                return outputFormatter.parse(outputFormatter.format(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
}
