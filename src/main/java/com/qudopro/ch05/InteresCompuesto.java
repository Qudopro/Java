package com.qudopro.ch05;

public class InteresCompuesto {
    public static void main(String[] args){
        double tasa = 0.05;
        double montoInicial = 1000.0;
        double montoFinal = 0.0;

        System.out.printf("%s%20s%n", "Ano", "Deposito");

        for(int i = 1; i <= 10; i++){
            montoFinal = montoInicial*Math.pow(1+tasa, i);
            System.out.printf("%02d%,20.2f%n",i, montoFinal);
        }
    }
}
