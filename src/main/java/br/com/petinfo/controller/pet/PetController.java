package br.com.petinfo.controller.pet;

import br.com.petinfo.model.dto.petdto.RegisterPetDto;
import br.com.petinfo.model.dto.petdto.VaccineDTO;
import br.com.petinfo.model.messages.pet.MessageAllDatasPetDto;
import br.com.petinfo.model.messages.pet.MessageListPageablePetDto;
import br.com.petinfo.model.messages.pet.MessageRegisterPetDto;
import br.com.petinfo.service.pet.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("{id}/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/findAll")
    public ResponseEntity<MessageListPageablePetDto> listPetByOwner(@PathVariable(name = "id") String tutor, @PageableDefault(size = 4, sort = {"petName", "specie"}) Pageable page){
        return petService.listPetByOwner(tutor, page);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<MessageAllDatasPetDto> specifcDataOfPetByID(@PathVariable(name = "petId") String param){
        return petService.specificDataOfPetByID(param);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageRegisterPetDto> registerPet(@RequestBody @Valid RegisterPetDto petDto, @PathVariable(name = "id") String tutor, UriComponentsBuilder uriBuilder){
        return petService.registerPet(petDto,tutor,uriBuilder);
    }

    @GetMapping("/{petId}/vaccines")
    public ResponseEntity getVaccines(@PathVariable(name = "petId") String param){
        return petService.getVaccines(param);
    }

    @PostMapping("/{petId}/vaccines")
    public ResponseEntity registerVaccine(@PathVariable(name = "petId") String param, @RequestBody @Valid VaccineDTO vaccineDTO){
        return petService.registerVaccine(param,vaccineDTO);
    }




}