package br.com.petspot.controller.petowner;

import br.com.petspot.service.petowner.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{id}")
public class PetOwnerController {

    @Autowired
    private PetOwnerService petOwnerService;

    @GetMapping("/feed")
    public ResponseEntity getFeed(@PathVariable(name = "id") String tutorID){
        return ResponseEntity.ok(petOwnerService.getFeed(tutorID));
    }
}
