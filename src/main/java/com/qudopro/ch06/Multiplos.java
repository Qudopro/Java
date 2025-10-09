package com.qudopro.ch06;

public class Multiplos {
    public static void main(String[] args){
        System.out.printf("El segundo valor ingresado %s multiplo del primero ",
                isMultiplo(3,4) ? "es" :"no es");
    }

    public static boolean isMultiplo(int numero1, int numero2){
        return numero2 % numero1 == 0;
    }
}
