package com.qudopro.ch03;

import java.util.Scanner;

public class PruebaFrecuenciaCardiaca {
    public static void main(String[] args){
        FrecuenciasCardiacas frecuenciasCardiacas = new FrecuenciasCardiacas("Diego", "Cabrera", 22, 07, 1999);

        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba su frecuencia cardiaca:\t");
        int frecuencia = entrada.nextInt();

        System.out.println("Informacion para " + frecuenciasCardiacas.getPrimerNombre() + " " + frecuenciasCardiacas.getApellidoPaterno());
        System.out.println("Tiene usted: " + frecuenciasCardiacas.age() + " anos");
        System.out.println("Su frecuencia cardiaca maxima debe ser: " + frecuenciasCardiacas.frecuenciaCardiacaMaxima());

        System.out.printf("El rango de frecuencia saludable debe oscilar entre %d y %d, y usted tiene: %d", frecuenciasCardiacas.frecuenciaCardiacaMinimaEsperada(),
                frecuenciasCardiacas.frecuenciaCardiacaMaximaEsperada(), frecuencia);

    }
}
