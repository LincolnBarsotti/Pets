package br.com.petspot.service.login;

import br.com.petspot.infra.security.TokenService;
import br.com.petspot.model.dto.logindto.*;
import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.entity.petOwner.PetOwner;
import br.com.petspot.model.messages.login.MessageWithEmail;
import br.com.petspot.repository.LoginRepository;
import br.com.petspot.service.email.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    public ResponseEntity<AuthTokenDto> signIn(LoginDto loginDto){
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.tokenGenerate((Login) authentication.getPrincipal());

            return ResponseEntity.ok(new AuthTokenDto(tokenJWT, "Logado com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthTokenDto(null, "Credenciais inválidas!"));
        }
    }

    public ResponseEntity<AuthTokenDto> register(RegisterUserDto registerUserDto, UriComponentsBuilder uriBuilder){

        if (loginRepository.existsLoginByEmail(registerUserDto.email())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new AuthTokenDto("Outra conta está usando o mesmo email."));
        }

        String encryptPassword = new BCryptPasswordEncoder().encode(registerUserDto.password());

        Login login = new Login(registerUserDto, encryptPassword);
        PetOwner petOwner = new PetOwner(registerUserDto);

        login.setPetOwner(petOwner);

        loginRepository.save(login);

        var uri = uriBuilder.path("/profile/{id}").buildAndExpand(login.getId()).toUri();

        var tokenJWT = tokenService.tokenGenerate(login);

//        sendEmail.sendRegisterEmail(login.getEmail(), petOwner.getName());

        return ResponseEntity.created(uri).body(new AuthTokenDto(tokenJWT,"Registro concluído"));
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
