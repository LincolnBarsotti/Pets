package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public record NewPasswordDto(
    @Email
    String email,
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+{}|;':\"/.,<>?])[a-zA-Z0-9~!@#$%^&*()_+{}|;':\"/.,<>?]+$",
            message = "Senha inválida!")
    @Min(value = 8, message = "Senha precisa ter no mínimo 8 caracteres")
    @Max(value = 23, message = "Senha precisa ter no máximo 23 caracteres")
    String senha
){

}
