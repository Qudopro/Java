package com.qudopro.ch06;

import java.util.Scanner;

public class ConversionTemperatura {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba 1 si ingresara la temperatura en Celsius, 2 en Fahrenheit para mostrar su equivalente:\t");
        int type = entrada.nextInt();

        if(type == 1){
            System.out.print("Ingrese el valor de la temperatura en celsius:\t");
            double temperatura = entrada.nextDouble();

            double fahrenheit = 9.0/5.0 * temperatura + 32;
            System.out.println("Su temperatura en fahrenheit es: " + fahrenheit);
        }else if(type == 2){
            System.out.print("Ingrese el valor de la temperatura en fahrenheit:\t");
            double temperatura = entrada.nextDouble();

            double celsius = 5.0/9.0 * (temperatura - 32);
            System.out.println("Su temperatura en celsius es: " + celsius);
        }else
            System.out.println("Valor no valido");
    }
}
