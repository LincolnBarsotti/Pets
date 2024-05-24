package br.com.petspot.service.login;

import br.com.petspot.model.dto.logindto.FormsContactDto;
import br.com.petspot.model.dto.logindto.LoginDto;
import br.com.petspot.model.dto.logindto.NewPasswordDto;
import br.com.petspot.model.dto.logindto.RegisterUserDto;
import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.entity.petOwner.PetOwner;
import br.com.petspot.model.messages.login.MessageWithEmail;
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

    public ResponseEntity<MessageWithEmail> signIn(LoginDto loginDto){
        Login auth = loginRepository.findByEmailAndPasswordLogin(loginDto.email(), loginDto.senha());

        if (auth != null){
            sendEmail.sendLoginEmail(auth.getEmail(), auth.getPetOwner().getName());
            return ResponseEntity.ok(new MessageWithEmail(loginDto.email(), "Usuário logado"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageWithEmail("Credenciais inválidas!"));
    }

    public ResponseEntity<MessageWithEmail> register(RegisterUserDto registerUserDto, UriComponentsBuilder uriBuilder){

        if (loginRepository.existsLoginByEmail(registerUserDto.email())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageWithEmail("Outra conta está usando o mesmo email."));
        }

        Login login = new Login(registerUserDto);
        PetOwner petOwner = new PetOwner(registerUserDto);

        login.setPetOwner(petOwner);

        loginRepository.save(login);

        var uri = uriBuilder.path("/profile/{id}").buildAndExpand(login.getId()).toUri();

        sendEmail.sendRegisterEmail(login.getEmail(), petOwner.getName());

        return ResponseEntity.created(uri).body(new MessageWithEmail(login.getEmail(), "Registro concluído"));
    }

    public ResponseEntity<MessageWithEmail> requestNewPassword(String email){
        if (loginRepository.existsLoginByEmail(email)){
            sendEmail.sendRequestNewPasswordEmail(email);
            return ResponseEntity.ok(new MessageWithEmail(email,"Email enviado com sucesso"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWithEmail("Verifique se o email foi digitado corretamente"));
    }

    public ResponseEntity<MessageWithEmail> recoverPassword(NewPasswordDto newPasswordDto){

        if (loginRepository.existsLoginByEmail(newPasswordDto.email())){
            Login login = loginRepository.getReferenceById(newPasswordDto.email());
            login.setPasswordLogin(newPasswordDto.senha());

            loginRepository.save(login);
            return ResponseEntity.ok(new MessageWithEmail("Senha alterada."));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageWithEmail("Verifique se o email foi digitado corretamente"));

    }


    public ResponseEntity<MessageWithEmail> formsContact(FormsContactDto formsContactDto) {

        sendEmail.contactUs(formsContactDto);
        return ResponseEntity.ok(new MessageWithEmail("Email enviado."));
    }
}
