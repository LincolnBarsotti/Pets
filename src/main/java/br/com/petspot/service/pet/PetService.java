package br.com.petspot.service.pet;

import br.com.petspot.model.dto.petdto.AllDatasPetDto;
import br.com.petspot.model.dto.petdto.RegisterPetDto;
import br.com.petspot.model.dto.petdto.SavedDatasPetDto;
import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.messages.pet.MessageAllDatasPetDto;
import br.com.petspot.model.messages.pet.MessageListPageablePetDto;
import br.com.petspot.model.messages.pet.MessageRegisterPetDto;
import br.com.petspot.model.entity.Pet.Pet;
import br.com.petspot.repository.LoginRepository;
import br.com.petspot.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private LoginRepository ownerRepository;

    public ResponseEntity<MessageListPageablePetDto> listPetByOwner(String tutor, Pageable page){
        return ResponseEntity.ok(
                new MessageListPageablePetDto(
                        petRepository.findAllByLogins_Id(tutor,page).map(AllDatasPetDto::new)
                )
        );
    }

    public ResponseEntity<MessageAllDatasPetDto> specifcDataOfPetByID(String param){
        Pet pet = petRepository.getReferenceById(param);
        return ResponseEntity.ok(new MessageAllDatasPetDto(new AllDatasPetDto(pet)));
    }

    public ResponseEntity<MessageRegisterPetDto> registerPet(@Valid RegisterPetDto petDto, String tutor, UriComponentsBuilder uriBuilder){

        Login owner =  ownerRepository.getReferenceById(tutor);

        Pet pet = new Pet(petDto);
        petRepository.save(pet);

        owner.getPet().add(pet);
        ownerRepository.save(owner);

        var uri = uriBuilder.path("pet/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(new MessageRegisterPetDto(new SavedDatasPetDto(pet)));
    }

    private boolean verificationExistenceOfPetOwner(String tutor){
        return ownerRepository.existsById(tutor);
    }

}
