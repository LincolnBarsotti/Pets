package br.com.petspot.model.messages.pet;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class MessageListPageablePetDto {
    private final String message = "Listagem feita com sucesso";
    private Page page;

    public MessageListPageablePetDto(Page page){
        this.page = page;
    }

}
