package br.com.petinfo.model.messages.petowner;

import br.com.petinfo.model.dto.petdto.FeedPetDto;
import lombok.Data;

@Data
public class MessageFeed {
    private String message;
    private FeedPetDto pets;

    public MessageFeed(FeedPetDto petDto){
        this.pets = petDto;
    }
}
