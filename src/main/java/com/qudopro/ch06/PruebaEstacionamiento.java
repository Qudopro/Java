package com.qudopro.ch06;

import java.util.Scanner;

public class PruebaEstacionamiento {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba las horas que estaciono el automovil:\t");
        int horas = entrada.nextInt();

        if(horas <= 24 && horas >= 0){
            Estacionamiento cliente1 = new Estacionamiento(horas);

            System.out.printf("El monto a cobrar es: $%.2f", cliente1.calcularCargos());
        }
    }
}
