package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.Email;

/**
 * @author Lincoln
 */
public record LoginDto(
        @Email
        String email,
        String senha
) {
}
