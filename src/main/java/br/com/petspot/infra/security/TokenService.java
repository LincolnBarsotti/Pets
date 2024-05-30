package br.com.petspot.infra.security;

import br.com.petspot.model.entity.login.Login;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private final Algorithm algoritimo = Algorithm.HMAC256(secret);

    public String tokenGenerate(Login usuario){
        try{
            return JWT.create()
                    .withIssuer("API Pet Spot")
                    .withIssuedAt(dateNow())
                    .withSubject(usuario.getEmail())
                    .withClaim("userId", usuario.getId())
                    .withExpiresAt(dateExpiration())
                    .sign(this.algoritimo);
        }catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT){

        try {
            return JWT.require(this.algoritimo)
                    .withIssuer("API Pet Spot")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("JWT inválido ou expirado");
        }

    }

    private Instant dateExpiration() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
    private Instant dateNow() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
    }

}
