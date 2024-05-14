package br.com.petspot.dto.registerDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record RegisterDto(
        @Email
        String email,
        @NotBlank
        String senha,
        String usuario,
        String nome,
        String sobrenome,
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
