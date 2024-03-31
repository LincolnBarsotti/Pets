package br.com.petspot.model.login;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

/**
 * @author Lincoln
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "email"})
@Entity(name = "Login")
public class Login {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;

    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@#$%^&+=!])(?=\\\\S+$).{6,}$",
            message = "A senha deve conter pelo menos 6 caracteres, com pelo menos uma letra maiúscula, uma letra minúscula, um dígito e um caractere especial." )
    private String senha;
}
