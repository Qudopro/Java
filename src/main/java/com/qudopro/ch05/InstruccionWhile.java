package com.qudopro.ch05;

public class InstruccionWhile {
    public static void main(String[] args){
        int contador = 1;

        while(contador <= 10){
            System.out.printf("%d\s", contador);
            ++contador;
        }
    }
}