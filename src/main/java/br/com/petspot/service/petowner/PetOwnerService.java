package br.com.petspot.service.petowner;

import br.com.petspot.model.dto.petdto.FeedPetDto;
import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.messages.petowner.MessageFeed;
import br.com.petspot.repository.LoginRepository;
import br.com.petspot.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PetOwnerService {

    @Autowired
    private PetOwnerRepository petOwnerRepository;
    @Autowired
    private LoginRepository loginRepository;

    public ResponseEntity getFeed(String tutorID) {
        Login tutor = loginRepository.getReferenceById(tutorID);
        if (tutor.getPet().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(new MessageFeed(new FeedPetDto(tutor)));
    }
}
