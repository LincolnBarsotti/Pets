package br.com.petspot.model.dto.petdto;

import br.com.petspot.model.entity.petOwner.PetOwner;


public class FeedPetDto extends PetSumaryDTO{

    private String ownerName;

    public FeedPetDto(PetOwner petOwner){
       this.ownerName = petOwner.getName();
    }
}
