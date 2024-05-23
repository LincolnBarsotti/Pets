package br.com.petspot.model.messages.login;

import lombok.Data;

@Data
public class MessageWithEmail {
    private String message;
    private String email;
    public MessageWithEmail(String email, String message){
        this.email = email;
        this.message = message;
    }
    public MessageWithEmail(String message){
        this.message = message;
    }
}
