package br.com.petspot.controller;


import br.com.petspot.dto.petDto.AllDatasPetDto;
import br.com.petspot.dto.petDto.RegisterPetDto;
import br.com.petspot.dto.petDto.SavedDatasPetDto;
import br.com.petspot.model.Pet.Pet;
import br.com.petspot.model.petOwner.PetOwner;
import br.com.petspot.repository.PetOwnerRepository;
import br.com.petspot.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("{id}/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetOwnerRepository ownerRepository;

    @GetMapping("/{petId}")
    public ResponseEntity specifcDataListOfPet(@PathVariable(name = "id") String tutor,@PathVariable(name = "petId") String param){
        Pet pet = petRepository.getReferenceById(param);
        return ResponseEntity.ok(new AllDatasPetDto(pet));
    }

    @GetMapping
    public ResponseEntity<Page<Pet>> allPets(@PathVariable(name = "id") String tutor, Pageable pageable){
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    @Transactional
    public ResponseEntity registerPet(@RequestBody RegisterPetDto petDto,@PathVariable(name = "id") String tutor, UriComponentsBuilder uriBuilder){

        PetOwner owner =  ownerRepository.getReferenceById(tutor);

        Pet pet = new Pet(petDto);
        petRepository.save(pet);

        owner.getPet().add(pet);
        ownerRepository.save(owner);

        var uri = uriBuilder.path("pet/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(new SavedDatasPetDto(pet));
    }

}
