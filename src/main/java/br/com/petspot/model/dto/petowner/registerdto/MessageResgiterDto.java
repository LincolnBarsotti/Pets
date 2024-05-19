package br.com.petspot.model.dto.petowner.registerdto;

import lombok.Data;

@Data
public class MessageResgiterDto {

    private final String message = "Usuário cadastrado com sucesso";
    private String email;

    public MessageResgiterDto(String email){
        this.email = email;
    }

}
