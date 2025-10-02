package com.qudopro.ch02;

public class CuadradosCubos {
    public static void main(String[] args){
        System.out.printf("%-20s%-20s%-20s%n", "numero", "cuadrado", "cubo");
        for(int i = 0; i < 11; i++){
            System.out.printf("%-20d%-20d%-20d%n", i, i*i, i*i*i);
        }
    }
}
