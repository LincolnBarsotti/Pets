package br.com.petspot.service.pet;

import br.com.petspot.model.dto.petdto.AllDatasPetDto;
import br.com.petspot.model.dto.petdto.RegisterPetDto;
import br.com.petspot.model.dto.petdto.SavedDatasPetDto;
import br.com.petspot.model.messages.pet.MessageAllDatasPetDto;
import br.com.petspot.model.messages.pet.MessageListPageablePetDto;
import br.com.petspot.model.messages.pet.MessageRegisterPetDto;
import br.com.petspot.model.entity.Pet.Pet;
import br.com.petspot.model.entity.petOwner.PetOwner;
import br.com.petspot.repository.PetOwnerRepository;
import br.com.petspot.repository.PetRepository;
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
    private PetOwnerRepository ownerRepository;

    public ResponseEntity<MessageListPageablePetDto> listPetByOwner(String tutor, Pageable page){
        return ResponseEntity.ok(
                new MessageListPageablePetDto(
                        petRepository.findAllByPetOwners_Id(tutor,page).map(AllDatasPetDto::new)
                )
        );
    }

    public ResponseEntity<MessageAllDatasPetDto> specifcDataOfPetByID(String param){
        Pet pet = petRepository.getReferenceById(param);
        return ResponseEntity.ok(new MessageAllDatasPetDto(new AllDatasPetDto(pet)));
    }

    public ResponseEntity<MessageRegisterPetDto> registerPet( RegisterPetDto petDto, String tutor, UriComponentsBuilder uriBuilder){

        PetOwner owner =  ownerRepository.getReferenceById(tutor);

        Pet pet = new Pet(petDto);
        petRepository.save(pet);

        owner.getPet().add(pet);
        ownerRepository.save(owner);

        var uri = uriBuilder.path("pet/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(new MessageRegisterPetDto(new SavedDatasPetDto(pet)));
    }


}
