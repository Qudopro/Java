package com.qudopro.ch02;

public class CrecimientoPoblacion {
    public static void main(String[] args){
        long poblacion = 8249844299L;
        double tasaCrecimiento = 0.0085;

        System.out.printf("%-8s%-25s%n", "Ano", "Poblacion");
        System.out.printf("%-8d%,-25d%n", 2025, poblacion);

        for(int i = 1; i <= 5; i++){
            long nuevaPoblacion = (long)(poblacion * tasaCrecimiento *i)+poblacion;
            System.out.printf("%-8d%,-25d%n", 2025+i,nuevaPoblacion);
        }
    }
}
