package br.com.petinfo.model.dto.logindto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @author Lincoln
 */
public record LoginDto(
        @Email
        String email,
        @NotBlank
        String password
) {
}
