package br.com.petspot.model.messages.pet;

import br.com.petspot.model.dto.petdto.SavedDatasPetDto;
import lombok.Data;

@Data
public class MessageRegisterPetDto {
    private final String message = "Pet cadastrado com sucesso.";
    private SavedDatasPetDto petDto;

    public MessageRegisterPetDto(SavedDatasPetDto petDto){
        this.petDto = petDto;
    }

}
