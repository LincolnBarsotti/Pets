package br.com.petinfo.infra.security.token;

import lombok.Data;

import java.time.Instant;

@Data
public class Token {

    private String token;
    private Instant dateExpired;
    private boolean valid;

}
