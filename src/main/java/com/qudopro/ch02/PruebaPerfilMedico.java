package com.qudopro.ch02;

import com.qudopro.ch03.PerfilMedico;

public class PruebaPerfilMedico {
    public static void main(String[] args){
        PerfilMedico perfilMedico = new PerfilMedico("Diego", "Cabrera", "Hombre", 22, 07, 1999, 170, 60);
        System.out.printf("Perfil medico para %s %s", perfilMedico.getPrimerNombre(), perfilMedico.getApellidoPaterno());
        System.out.printf("%nSu sexo es: %s%n", perfilMedico.getSexo());
        System.out.printf("Su fecha de nacimiento es: %02d/%02d/%d%n", perfilMedico.getDay(), perfilMedico.getMonth(), perfilMedico.getYear());
        System.out.printf("Tiene una altura (en metros) de: %.2f y un peso de: %d kg%n", perfilMedico.getAlturaCm()/100.0, perfilMedico.getPesoKg());
        System.out.printf("Su edad es: %d%n", perfilMedico.getAge());
        System.out.printf("Su frecuencia cardiaca maxima es: %d%n", perfilMedico.frecuenciaCardiacaMaxima());
        System.out.printf("Su frecuencia cardiaca esperada maxima es: %d%n", perfilMedico.frecuenciaCardiacaMaximaEsperada());
        System.out.printf("Su frecuencia cardiaca esperada minima es: %d%n", perfilMedico.frecuenciaCardiacaMinimaEsperada());
    }
}
