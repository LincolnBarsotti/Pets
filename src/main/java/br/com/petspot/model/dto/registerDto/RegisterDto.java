package br.com.petspot.model.dto.registerDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record RegisterDto(
        @Email
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+{}|;':\"/.,<>?])[a-zA-Z0-9~!@#$%^&*()_+{}|;':\"/.,<>?]+$",
                message = "Sua senha deve contar 1 Maiuscula, 1 minuscula, 1 número e um caracter especial'(@,!,#,$ ...)'")
        String senha,
        @NotBlank
        String usuario,
        @NotBlank
        String nome,
        @NotBlank
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
