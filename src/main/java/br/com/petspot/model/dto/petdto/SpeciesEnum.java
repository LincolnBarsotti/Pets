package br.com.petspot.model.dto.petdto;

public enum SpeciesEnum {
    DOG(1), CAT(2);

    private final int value;

    SpeciesEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
