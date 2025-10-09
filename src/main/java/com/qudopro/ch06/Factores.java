package com.qudopro.ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factores {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        List<Integer> listNumbers = new ArrayList<>();
        for(int i = 1000; i <= 1_000_000; i++){
            if(isPerfect(i))
                listNumbers.add(i);
        }

        listNumbers.stream().forEach(
                x -> {
                    System.out.println(x);
                }
        );
    }

    public static boolean isPerfect(int numero){
        boolean status = false;
        int resultado = 0;

        for(int i = 0; resultado < numero; i++){
            if(i == 0)
                continue;

            resultado = resultado + i;

            if( resultado == numero){
                status = true;
                break;
            }
        }

        return status;
    }
}
