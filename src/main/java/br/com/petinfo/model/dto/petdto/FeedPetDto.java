package br.com.petinfo.model.dto.petdto;

import br.com.petinfo.model.entity.tutors.Person;


public class FeedPetDto extends PetSumaryDTO{

    private String tutor;

    public FeedPetDto(Person person){
       this.tutor = person.getNamePerson();
    }
}
