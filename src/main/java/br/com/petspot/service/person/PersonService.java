package br.com.petspot.service.person;

import br.com.petspot.model.dto.petdto.FeedPetDto;
import br.com.petspot.model.entity.tutors.Person;
import br.com.petspot.model.messages.petowner.MessageFeed;
import br.com.petspot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity getFeed(String tutorID) {
        Person tutor = personRepository.getReferenceById(tutorID);
        if (tutor.getPet().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(new MessageFeed(new FeedPetDto(tutor)));
    }
}
