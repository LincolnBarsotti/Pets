package br.com.petspot.model.dto.petdto;

import br.com.petspot.model.entity.Pet.Pet;

import java.util.Date;

public record
AllDatasPetDto(
        String id,
        String nome,
        String peso,
        Date nascimento,
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
