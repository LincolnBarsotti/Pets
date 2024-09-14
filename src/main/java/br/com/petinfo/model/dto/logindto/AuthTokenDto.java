package br.com.petinfo.model.dto.logindto;


public record AuthTokenDto(String token, String userId, String message) {
    public AuthTokenDto(String message){
        this(null, null, message);
    }

    public AuthTokenDto(String token, String userId, String message){
        this.userId = userId;
        this.token = token;
        this.message = message;
    }
}
