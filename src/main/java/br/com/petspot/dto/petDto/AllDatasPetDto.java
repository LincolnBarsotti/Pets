package br.com.petspot.dto.petDto;

import br.com.petspot.model.Pet.Pet;

import java.util.Date;

public record
AllDatasPetDto(
        String id,
        String nome,
        String peso,
        Date nascimento,
        String especie,
        String raca,
        int genero

) {
    public AllDatasPetDto(Pet pet){
        this(
                pet.getId(), pet.getPetName(), pet.getPetWeight(),
                pet.getPetBirthday(), pet.getSpecie(), pet.getRace(),
                pet.getGender()
                );
    }
}
