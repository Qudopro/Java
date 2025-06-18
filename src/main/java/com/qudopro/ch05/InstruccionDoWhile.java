package com.qudopro.ch05;

public class InstruccionDoWhile {
    public static void main(String[] args){
        int contador = 1;

        do{
            System.out.printf("%d\s", contador);
            ++contador;
        }while(contador<=10);

        System.out.println();
    }
}
