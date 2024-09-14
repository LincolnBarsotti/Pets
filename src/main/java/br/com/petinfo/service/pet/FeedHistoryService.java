package br.com.petinfo.service.pet;

import br.com.petinfo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FeedHistoryService {

    @Autowired
    private PetRepository petRepository;

    public ResponseEntity feedHistory(){
        return ResponseEntity.ok("Fazendo o BODY...");
    }

}