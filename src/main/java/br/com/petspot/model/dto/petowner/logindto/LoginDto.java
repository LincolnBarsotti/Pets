package br.com.petspot.model.dto.petowner.logindto;

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
