package br.com.petspot.model.dto.logindto;

public enum TypesUsers {
    PETOWNER(1),  DOCTOR(2),  OTHERS(3);

    private final int value;

    TypesUsers(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
