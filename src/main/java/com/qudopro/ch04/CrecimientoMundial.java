package com.qudopro.ch04;

public class CrecimientoMundial {
    public static void main(String[] args){
        System.out.printf("%4s%20s%-20s%n", "Year", "Poblacion Anual", "Tasa de crecimiento");
        long population = 8250259086L;
        double tasaCrecimiento = 0.0085;
        int year = 2025;
        for(int i = 1; i <= 75;  i++){

            population = (long)(population+population*tasaCrecimiento);
            System.out.printf("%d%,20d%20.2f%n", 2025+i, population, tasaCrecimiento);
        }
    }
}
