package com.qudopro.ch04;

public class PotenciaDos {
    public static void main(String[] args){
        System.out.printf("%-25s%-10s%n", "Potencia de 2", "Valor");
        int potencia = 0;
        while(potencia <= 1000){
            System.out.printf("%-25d%,.2f%n", potencia, Math.pow(2, potencia));
            potencia++;
        }
    }

}

