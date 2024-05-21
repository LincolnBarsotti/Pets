package br.com.petspot.controller.petowner;

import br.com.petspot.model.dto.logindto.LoginDto;
import br.com.petspot.model.dto.logindto.RequestEmailDto;
import br.com.petspot.model.dto.petowner.registerdto.RegisterDto;
import br.com.petspot.model.messages.login.MessageToRequestNewPassword;
import br.com.petspot.service.petowner.PetOwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PetOwnerController {
    @Autowired
    private PetOwnerService petOwnerService;

    @PostMapping
    @RequestMapping("/register")
    private ResponseEntity register(@RequestBody @Validated RegisterDto registerDto, UriComponentsBuilder uriBuilder){
        return petOwnerService.register(registerDto, uriBuilder);
    }

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity signIn(@RequestBody @Valid LoginDto loginDto) {
        return petOwnerService.signIn(loginDto);
    }

    @PutMapping
    @RequestMapping("/request-new-password")
    public ResponseEntity<MessageToRequestNewPassword> requestNewPassword(@RequestBody @Valid RequestEmailDto emailDto){
        return petOwnerService.recoverPassword(emailDto.email());
    }

}
