package com.qudopro.ch06;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primos {
    public static void main(String[] args){
        List<Integer> integerList = new ArrayList<>();

        for(int i = 1; i <= 10000; i++){
            if(isPrimo(i))
                integerList.add(i);
        }

        System.out.println("Se mostraran todos los numeros pares del 1 al 10000");

        integerList.stream().forEach(
                x -> System.out.println(x)
        );

    }

    public static boolean isPrimo(int number){
        boolean status = false;
        int resultado = 1;

        for(int i = 2; i <= number; i++){
            resultado = number%i;
            if(resultado == 0 && number == i)
                status = true;
            else if(resultado == 0 && number != i)
                break;
/*
            if(!(number/i == 0)){
                status = true;
                break;
            }

 */
        }

        return status;
    }
}
