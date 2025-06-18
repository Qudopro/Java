package com.qudopro.ch04;

import java.util.Scanner;

public class EstructurasAnidadas {
    public static void main(String[] args){
        Scanner  entrada = new Scanner(System.in);

        int aprobados = 0;
        int reprobados = 0;
        int contador = 1;

        while(contador <= 10){
            System.out.print("Introduzca \"1\" si el estudiante aprobo, \"2\" si reprobo:\t");
            int calificacion = entrada.nextInt();

            if(calificacion == 1)
                aprobados = aprobados + 1;
            else if(calificacion == 2)
                reprobados = reprobados + 1;
            else {
                System.out.println("Valor no valido");
                continue;
            }
            contador = contador + 1;
        }

        System.out.println("Numero de aprobados:\t" +  aprobados);

        if(aprobados >= 8)
            System.out.println("Felicidades. Tiene Bono!");
    }
}
