package com.qudopro.ch05;

import java.util.Scanner;

public class InstruccionSwitch {
    public static void main(String[] args){
        int total = 0;
        int contador = 0;
        int calificacionA = 0;
        int calificacionB = 0;
        int calificacionC = 0;
        int calificacionD = 0;
        int calificacionF = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduzca una calificacion de 0 a 100 o -1 para salir:\t");
        int calificacion = entrada.nextInt();

        while(calificacion != -1){
            total += calificacion;
            ++contador;

            switch(calificacion/10){
                case 10:
                case 9:
                    ++calificacionA;
                    break;
                case 8:
                    ++calificacionB;
                    break;
                case 7:
                    ++calificacionC;
                    break;
                case 6:
                    ++calificacionD;
                    break;
                case 5:
                    ++calificacionF;
                    break;
                default:
                    break;
            }
            System.out.print("Introduzca otra calificacion de 0 a 100 o -1 para salir:\t");
            calificacion = entrada.nextInt();
        }

        System.out.println("Reporte de calificaciones");

        if(contador != 0){
            double promedio = (double)total/contador;

            System.out.printf("El total de las calificaciones introducidas es: %d%n", contador);
            System.out.printf("Promedio: %.2f%n", promedio);

            System.out.printf("%s:\s%d%n%s:\s%d%n%s:\s%d%n%s:\s%d%n%s:\s%d%n", "Alumnos con A",
                    calificacionA,"Alumnos con B", calificacionB,"Alumnos con C", calificacionC,"Alumnos con D", calificacionD, "Alumnos con F", calificacionF);
        }else{
            System.out.println("No se introdujeron calificaciones");
        }
    }
}
