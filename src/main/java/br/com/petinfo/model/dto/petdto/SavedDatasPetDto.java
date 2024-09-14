package br.com.petinfo.model.dto.petdto;

import br.com.petinfo.model.entity.Pet.Pet;

public record SavedDatasPetDto(
        String id,
        String name,
        int gender,
        String age
) {
    public SavedDatasPetDto(Pet pet){
        this(pet.getId(), pet.getPetName(), pet.getGender(), pet.getPetBirthday());
    }
}
