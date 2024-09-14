package br.com.petinfo.model.messages.pet;

import br.com.petinfo.model.dto.petdto.AllDatasPetDto;
import lombok.Data;

@Data
public class MessageAllDatasPetDto {
    private final String message = "Dados do Pet carregados com sucesso.";
    private AllDatasPetDto petDto;

    public MessageAllDatasPetDto(AllDatasPetDto petDto){
        this.petDto = petDto;
    }
}
