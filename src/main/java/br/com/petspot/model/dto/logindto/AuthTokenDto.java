package br.com.petspot.model.dto.logindto;


import org.springframework.beans.factory.annotation.Autowired;

public record AuthTokenDto(String token, String userId, String message) {
    public AuthTokenDto(String message){
        this(null, message, null);
    }

    public AuthTokenDto(String token, String userId, String message){
        this.userId = userId;
        this.token = token;
        this.message = message;
    }
}
