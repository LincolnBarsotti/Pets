package br.com.petspot.controller.login;

import br.com.petspot.model.dto.logindto.LoginDto;
import br.com.petspot.model.dto.logindto.RegisterUserDto;
import br.com.petspot.model.dto.logindto.RequestEmailDto;
import br.com.petspot.model.messages.login.MessageToRequestNewPassword;
import br.com.petspot.service.login.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @RequestMapping("/register")
    private ResponseEntity register(@RequestBody @Validated RegisterUserDto registerUserDto, UriComponentsBuilder uriBuilder){
        return loginService.register(registerUserDto, uriBuilder);
    }

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity signIn(@RequestBody @Valid LoginDto loginDto) {
        return loginService.signIn(loginDto);
    }

    @PutMapping
    @RequestMapping("/request-new-password")
    public ResponseEntity<MessageToRequestNewPassword> requestNewPassword(@RequestBody @Valid RequestEmailDto emailDto){
        return loginService.recoverPassword(emailDto.email());
    }
    
}
