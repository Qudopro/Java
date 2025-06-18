package com.qudopro.ch04;

import java.util.Scanner;

public class PromedioRepeticionDefinida {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        int total = 0;
        int contador = 1;

        while (contador <= 3) {
            System.out.print("Introduzca una calificacion:\t");
            int calificacion = entrada.nextInt();

            total = total + calificacion;
            contador = contador + 1;
        }

        double promedio = (double)total / (contador-1);
        System.out.printf("El promedio de la clase, para los 3 estudiantes fue: %.2f%n", promedio);
    }

}
