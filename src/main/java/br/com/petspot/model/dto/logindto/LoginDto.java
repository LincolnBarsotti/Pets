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
        String senha
) {
}
