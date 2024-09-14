package br.com.petinfo.model.dto.petdto;

import br.com.petinfo.model.entity.Pet.Pet;

public record
AllDatasPetDto(
        String id,
        String name,
        String weight,
        String birthday,
        String species,
        String race,
        Integer gender,
        Integer age,
        String description

) {
    public AllDatasPetDto(Pet pet){
        this(
                pet.getId(), pet.getPetName(), pet.getPetWeight(),
                pet.getPetBirthday(), pet.getSpecie(), pet.getRace(),
                pet.getGender(), pet.getAgeInYears() , null
        );
    }
}
