package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FormsContactDto(
        @Email
        String email,

        @NotBlank
        String subject,

        @NotBlank
        String body,

        @NotBlank
        String name,

        @NotBlank
        String surname

){
    public String getNameAndBody(){
        return this.name + " " + this.surname + "\n" + body ;
    }
}
