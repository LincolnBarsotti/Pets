package br.com.petspot.controller.login;

import br.com.petspot.model.dto.logindto.*;
import br.com.petspot.model.messages.login.MessageWithEmail;
import br.com.petspot.service.login.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<MessageWithEmail> register(@RequestBody @Validated RegisterUserDto registerUserDto, UriComponentsBuilder uriBuilder){
        return loginService.register(registerUserDto, uriBuilder);
    }

    @PostMapping("/login")
    public ResponseEntity<MessageWithEmail> signIn(@RequestBody @Valid LoginDto loginDto) {
        return loginService.signIn(loginDto);
    }

    @PutMapping("/request-new-password")
    public ResponseEntity<MessageWithEmail> requestNewPassword(@RequestBody @Valid RequestEmailDto emailDto){
        return loginService.requestNewPassword(emailDto.email());
    }

    @PutMapping("/new-password")
    @Transactional
    public ResponseEntity<MessageWithEmail> newPassword(@RequestBody @Valid NewPasswordDto newPasswordDto){
        return loginService.recoverPassword(newPasswordDto);
    }

    @PostMapping("/forms-contact")
    public ResponseEntity<MessageWithEmail> logout(@RequestBody @Valid FormsContactDto formsContactDto){

        return loginService.formsContact(formsContactDto);
    }



}
