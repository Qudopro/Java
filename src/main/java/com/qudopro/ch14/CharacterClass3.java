package com.qudopro.ch14;

public class CharacterClass3 {
    public static void main(String[] args){
        Character char1 = 'A';
        Character char2 = 'a';

        System.out.printf("char1 = %s%nchar2 = %s%n", char1.charValue(), char2.charValue());

        if(char1.equals(char2))
            System.out.println("Los objetos son iguales");
    }
}
