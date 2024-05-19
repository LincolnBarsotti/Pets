package br.com.petspot.service.petowner;

import br.com.petspot.model.dto.petowner.logindto.LoginDto;
import br.com.petspot.model.dto.petowner.logindto.MessageLoginDto;
import br.com.petspot.model.dto.petowner.registerdto.MessageResgiterDto;
import br.com.petspot.model.dto.petowner.registerdto.RegisterDto;
import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.entity.petOwner.PetOwner;
import br.com.petspot.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PetOwnerService {

    @Autowired
    private LoginRepository loginRepository;

    public ResponseEntity signIn(LoginDto loginDto){
        Login auth = loginRepository.findByEmailAndPasswordLogin(loginDto.email(), loginDto.senha());

        if (auth != null){
            return ResponseEntity.ok(new MessageLoginDto(loginDto.email()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }

    public ResponseEntity register(RegisterDto registerDto, UriComponentsBuilder uriBuilder){

        if (loginRepository.existsLoginByEmail(registerDto.email())){
            return ResponseEntity.ok("Outra conta está usando o mesmo email.");
        }

        Login login = new Login(registerDto);
        PetOwner petOwner = new PetOwner(registerDto);

        login.setPetOwner(petOwner);

        loginRepository.save(login);

        var uri = uriBuilder.path("/profile/{id}").buildAndExpand(login.getId()).toUri();

        return ResponseEntity.created(uri).body(new MessageResgiterDto(login.getEmail()));
    }
}
