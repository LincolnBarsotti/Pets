package br.com.petspot.model.dto.petdto;

import br.com.petspot.model.entity.login.Login;
import br.com.petspot.model.entity.tutors.Person;


public class FeedPetDto extends PetSumaryDTO{

    private String tutor;

    public FeedPetDto(Person person){
       this.tutor = person.getNamePerson();
    }
}
