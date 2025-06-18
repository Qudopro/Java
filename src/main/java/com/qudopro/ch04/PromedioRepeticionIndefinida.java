package com.qudopro.ch04;

import java.util.Scanner;

public class PromedioRepeticionIndefinida {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        int total = 0;
        int contador = 0;

        System.out.print("Escriba una calificacion o -1 para terminar:\t");
        int calificacion = entrada.nextInt();

        while(calificacion != -1){
            total = total + calificacion;
            contador = contador + 1;

            System.out.print("Escriba otra calificacion o -1 para terminar:\t");
            calificacion = entrada.nextInt();
        }

        if(contador != 00){
            double promedio = (double)total/contador;

            System.out.printf("El promedio de la clase para los %d estudiantes fue: %.2f", contador, promedio);
        }else
            System.out.println("No se han introducido calificaciones");
    }
}
