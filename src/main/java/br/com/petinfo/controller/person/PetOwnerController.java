package br.com.petinfo.controller.person;

import br.com.petinfo.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{id}")
public class PetOwnerController {

    @Autowired
    private PersonService personService;

    @GetMapping("/feed")
    public ResponseEntity getFeed(@PathVariable(name = "id") String tutorID){
        return ResponseEntity.ok(personService.getFeed(tutorID));
    }
}
