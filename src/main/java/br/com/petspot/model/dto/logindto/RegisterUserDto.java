package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record RegisterUserDto(
        @Email
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+{}|;':\"/.,<>?])[a-zA-Z0-9~!@#$%^&*()_+{}|;':\"/.,<>?]+$"
        , message = "Senha fora de padrão!")
        String senha,
        @NotBlank
        @Size(min = 2, max = 18)
        String nome,
        @NotBlank
        @Size(min = 2, max = 18)
        String sobrenome,
        @NotBlank
        String dataDeNascimento
) {

     public Date getDate() {
         SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");  // Input format
         SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");  // Output format
            try {
                Date date = inputFormatter.parse(dataDeNascimento);
                return outputFormatter.parse(outputFormatter.format(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
}
