package br.com.petspot.controller.pet;


import br.com.petspot.service.pet.FeedHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("{id}/pet")
public class FeedHistoryController {

    @Autowired
    private FeedHistoryService feedHistoryService;

    @GetMapping("feed")
    public ResponseEntity feedHistory(){
        return feedHistoryService.feedHistory();
    }

}
