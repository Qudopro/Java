package com.qudopro.ch06;

import java.util.Scanner;

public class Maximo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Pon 3 valores separados por espacios:\t");
        double x = entrada.nextDouble();
        double y = entrada.nextDouble();
        double z = entrada.nextDouble();

        //Determina el valor máximo
        double maximoValor = maximo(x, y, z);

        System.out.println("El valor mas grande ingresado fue:\t" + maximoValor);
    }

    private static double maximo(double x, double y, double z){
        double maximo = x;

        if(maximo < y)
            maximo = y;

        if(maximo < z)
            maximo = z;

        return maximo;
    }

}
