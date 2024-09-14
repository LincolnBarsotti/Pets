package br.com.petinfo.infra.security.token;

import br.com.petinfo.model.entity.login.Login;
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

    public String tokenGenerate(Login usuario){
        try{
            Algorithm algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Pet Spot")
                    .withSubject(usuario.getEmailLogin())
                    .withIssuedAt(dateNow())
                    .withExpiresAt(dateExpiration())
                    .withClaim("userId", usuario.getPersonLogin().getIdPerson())

                    .sign(algoritimo);
        }catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT){
        try {
            Algorithm algoritimo = Algorithm.HMAC256(secret);
            return JWT.require(algoritimo)
                    .withIssuer("API Pet Spot")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("JWT inválido ou expirado");
        }
    }


    private Instant dateExpiration() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
    private Instant dateNow() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
    }

}
