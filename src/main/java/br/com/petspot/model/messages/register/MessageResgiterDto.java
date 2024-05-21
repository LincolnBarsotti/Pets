package br.com.petspot.model.messages.register;

import lombok.Data;

@Data
public class MessageResgiterDto {

    private final String message = "Usuário cadastrado com sucesso";
    private String email;

    public MessageResgiterDto(String email){
        this.email = email;
    }

}
