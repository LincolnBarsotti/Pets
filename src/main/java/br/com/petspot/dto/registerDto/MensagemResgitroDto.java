package br.com.petspot.dto.registerDto;

import lombok.Data;

@Data
public class MensagemResgitroDto{

    private final String message = "Usuário foi cadastrado com sucesso";
    private String email;

    public MensagemResgitroDto(String email){
        this.email = email;
    }

}
