package br.com.petspot.infra.error_treatment;

import br.com.petspot.model.messages.login.MessageWithEmail;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {

        // PRECISA ALTERAAR !!!!!!

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
        ;
        StringBuilder campos = new StringBuilder();
        StringBuilder mensagens = new StringBuilder();

        for (FieldError fieldError : ex.getFieldErrors()) {
            campos.append(fieldError.getField()).append(", ");
            mensagens.append(fieldError.getDefaultMessage()).append(", ");
        }

        String campo = mensagens.toString().substring(0, mensagens.length() - 2);
        String message = campos.toString().substring(0, campos.length() - 2);

        return ResponseEntity.badRequest().body(new DadosErroValidacao(message, campo));
    }

    private record DadosErroValidacao(String campo, String message) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

}