package br.com.petinfo.model.dto.petdto;

public enum SpeciesEnum {
    UNKNOWN(0), DOG(1), CAT(2);

    private final int value;

    SpeciesEnum(final int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
