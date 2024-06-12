package br.com.petspot.model.dto.petdto;

import br.com.petspot.model.entity.login.Login;


public class FeedPetDto extends PetSumaryDTO{

    private String tutor;

    public FeedPetDto(Login person){
       this.tutor = person.getPersonLogin().getNamePerson();
    }
}
