package com.qudopro.ch02;

import java.util.Scanner;

public class CalculadoraIndiceMasaCorporal {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduzca su peso en kilogramos: ");
        int pesoKilogramos = entrada.nextInt();

        System.out.print("Introduzca su altura en metros: ");
        double alturaMetros = entrada.nextDouble();

        String mensaje = "";
        double BMI = pesoKilogramos/(alturaMetros*alturaMetros);
        if(BMI < 18.5)
            mensaje = "Bajo peso: menos de 18.5";
        else if(BMI < 25)
            mensaje = "Normal: entre 18.5 y 24.9";
        else if(BMI < 30)
            mensaje = "Sobrepeso: entre 25 y 29.9";
        else
            mensaje = "Obeso: 30 o mas";

        System.out.printf("%s%n%s", "VALORES DE BMI", mensaje);

    }
}
