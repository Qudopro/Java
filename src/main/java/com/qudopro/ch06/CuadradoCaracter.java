package com.qudopro.ch06;

public class CuadradoCaracter {
    public static void main(String[] args){
        int lado = 3;
        char character = '#';

        for(int i = 0; i < lado; i++){
            System.out.print(String.valueOf(character).repeat(lado));
            System.out.println();
        }
    }
}
