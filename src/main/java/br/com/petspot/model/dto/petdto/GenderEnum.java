package br.com.petspot.model.dto.petdto;

public enum GenderEnum {
    MALE(1),    FEMALE(2);

    private final int value;

    GenderEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
