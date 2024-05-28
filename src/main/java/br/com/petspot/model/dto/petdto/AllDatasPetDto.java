package br.com.petspot.model.dto.petdto;

import br.com.petspot.model.entity.Pet.Pet;
import jakarta.validation.constraints.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public record
AllDatasPetDto(
        String id,
        String nome,
        String peso,
        String nascimento,
        String especie,
        String raca,
        Integer genero

) {
    public AllDatasPetDto(Pet pet){
        this(
                pet.getId(), pet.getPetName(), pet.getPetWeight(),
                pet.getPetBirthday(), pet.getSpecie(), pet.getRace(),
                pet.getGender()
        );
    }
}
