package com.qudopro.ch02;

import java.util.Scanner;

public class PositivosCeroNegativos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        System.out.println("Introduzca 5 digitos");
        int numero1 = entrada.nextInt(), numero2 = entrada.nextInt(), numero3 = entrada.nextInt(), numero4 = entrada.nextInt(), numero5 = entrada.nextInt();

        if(numero1 < 0)
            negativos++;
        else if(numero1 == 0)
            ceros++;
        else
            positivos++;

        if(numero2 < 0)
            negativos++;
        else if(numero2 == 0)
            ceros++;
        else
            positivos++;

        if(numero3 < 0)
            negativos++;
        else if(numero3 == 0)
            ceros++;
        else
            positivos++;

        if(numero4 < 0)
            negativos++;
        else if(numero4 == 0)
            ceros++;
        else
            positivos++;

        if(numero5 < 0)
            negativos++;
        else if(numero5 == 0)
            ceros++;
        else
            positivos++;

        System.out.println("Numero de positivos introducidos: " + positivos);
        System.out.println("Numero de negativos introducidos: " + negativos);
        System.out.println("Numero de ceros introducidos: " + ceros);
    }
}
