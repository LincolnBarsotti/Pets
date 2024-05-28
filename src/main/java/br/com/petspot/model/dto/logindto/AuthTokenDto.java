package br.com.petspot.model.dto.logindto;


import org.springframework.beans.factory.annotation.Autowired;

public record AuthTokenDto(String token, String message) {
    public AuthTokenDto(String message){
        this(null, message);
    }
    public AuthTokenDto(String token, String message){
        this.token = token;
        this.message = message;
    }
}
