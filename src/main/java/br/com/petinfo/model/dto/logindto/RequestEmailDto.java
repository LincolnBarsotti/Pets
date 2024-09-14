package br.com.petinfo.model.dto.logindto;

import jakarta.validation.constraints.Email;

public record RequestEmailDto(
        @Email
        String email
) {
}
