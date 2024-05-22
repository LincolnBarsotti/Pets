package br.com.petspot.service.login;

import br.com.petspot.model.dto.logindto.LoginDto;
import br.com.petspot.model.dto.logindto.RegisterUserDto;
import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.entity.petOwner.PetOwner;
import br.com.petspot.model.messages.login.MessageLoginDto;
import br.com.petspot.model.messages.login.MessageToRequestNewPassword;
import br.com.petspot.model.messages.register.MessageResgiterDto;
import br.com.petspot.repository.LoginRepository;
import br.com.petspot.service.email.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private SendEmail sendEmail;

    public ResponseEntity signIn(LoginDto loginDto){
        Login auth = loginRepository.findByEmailAndPasswordLogin(loginDto.email(), loginDto.senha());

        if (auth != null){
            sendEmail.sendLoginEmail(auth.getEmail(), auth.getPetOwner().getName());
            return ResponseEntity.ok(new MessageLoginDto(loginDto.email()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }

    public ResponseEntity register(RegisterUserDto registerUserDto, UriComponentsBuilder uriBuilder){

        if (loginRepository.existsLoginByEmail(registerUserDto.email())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Outra conta está usando o mesmo email.");
        }

        Login login = new Login(registerUserDto);
        PetOwner petOwner = new PetOwner(registerUserDto);

        login.setPetOwner(petOwner);

        loginRepository.save(login);

        var uri = uriBuilder.path("/profile/{id}").buildAndExpand(login.getId()).toUri();

        sendEmail.sendRegisterEmail(login.getEmail(), petOwner.getName());

        return ResponseEntity.created(uri).body(new MessageResgiterDto(login.getEmail()));
    }

    public ResponseEntity<MessageToRequestNewPassword> recoverPassword(String email){
        if (loginRepository.existsLoginByEmail(email)){
            sendEmail.sendEmail(email, "Recuperação de senha","Houve um pedido de solicitação de senha, por favor acesse o link:\n link");
            return ResponseEntity.ok(new MessageToRequestNewPassword("Email enviado com sucesso"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageToRequestNewPassword("Verifique se o email foi digitado corretamente"));
    }


}
