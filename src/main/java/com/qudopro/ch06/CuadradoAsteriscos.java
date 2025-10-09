package com.qudopro.ch06;

public class CuadradoAsteriscos {
    public static void main(String[] args){
        int lado = 10;

        for(int i = 0; i < lado; i++){
            System.out.print("*".repeat(lado));
            System.out.println();
        }
    }
}
