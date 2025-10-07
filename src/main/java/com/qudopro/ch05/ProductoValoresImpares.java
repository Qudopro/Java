package com.qudopro.ch05;

public class ProductoValoresImpares {
    public static void main(String[] args){
        int producto = 1;
        for(int i = 1; i <= 15; i+=2){
            producto *= i;
        }

        System.out.printf("El producto de los valores introducidos es: %,d", producto);
    }
}
