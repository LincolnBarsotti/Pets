package br.com.petspot.controller.pet;

import br.com.petspot.model.dto.petdto.AllDatasPetDto;
import br.com.petspot.model.dto.petdto.RegisterPetDto;
import br.com.petspot.model.dto.petdto.messages.MessageAllDatasPetDto;
import br.com.petspot.model.dto.petdto.messages.MessageListPageablePetDto;
import br.com.petspot.model.dto.petdto.messages.MessageRegisterPetDto;
import br.com.petspot.service.pet.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("{id}/pet")
@CrossOrigin(origins = "http://localhost:5173")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/findAll")
    public ResponseEntity<MessageListPageablePetDto> listPetByOwner(@PathVariable(name = "id") String tutor, @PageableDefault(size = 2, sort = {"petName"}) Pageable page){
        return petService.listPetByOwner(tutor, page);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<MessageAllDatasPetDto> specifcDataOfPetByID(@PathVariable(name = "petId") String param){
        return petService.specifcDataOfPetByID(param);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageRegisterPetDto> registerPet(@RequestBody RegisterPetDto petDto, @PathVariable(name = "id") String tutor, UriComponentsBuilder uriBuilder){
        return petService.registerPet(petDto,tutor,uriBuilder);
    }

}
