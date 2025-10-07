package com.qudopro.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImprimirGraficos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        List<Integer> listData = new ArrayList<>();
        int contador = 0;

        do{
            System.out.println("Escriba un numero entero entre 1 y 30:\t");
            int dato = entrada.nextInt();

            if(dato >= 1 && dato <= 30)
                listData.add(dato);
            else {
                System.out.println("Valor no valido, vuelve a intentarlo");
                continue;
            }
            contador++;
        }while(contador < 5);

        System.out.printf("%20s%20s%n", "Valor introducido", "Asteriscos");

        for(int i = 0; i < listData.size(); i++){
            System.out.printf("%20s%10s", listData.get(i), "");
            for(int j = 0; j < listData.get(i); j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
