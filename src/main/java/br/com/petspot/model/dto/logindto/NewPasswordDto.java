package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record NewPasswordDto(
    @Email
    String email,
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+{}|;':\"/.,<>?])[a-zA-Z0-9~!@#$%^&*()_+{}|;':\"/.,<>?]+$",
            message = "Senha inválida!")
    String senha
){

}
