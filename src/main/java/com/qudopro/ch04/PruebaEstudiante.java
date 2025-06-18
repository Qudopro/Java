package com.qudopro.ch04;

public class PruebaEstudiante {
    public static void main(String[] args){
        Estudiante estudiante01 = new Estudiante("Diego", 85.0);

        System.out.printf("La calificacion del estudiante %s es: %s", estudiante01.obtenerNombre(), estudiante01.obtenerCalificacion());
    }
}
