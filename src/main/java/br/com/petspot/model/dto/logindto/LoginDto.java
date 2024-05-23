package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

/**
 * @author Lincoln
 */
public record LoginDto(
        @Email
        String email,
        @NotBlank
        @Max(value = 23, message = "Senha precisa ter no máximo 23 caracteres")
        String senha
) {
}
