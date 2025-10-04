package com.qudopro.ch04;

public class PruebaCalculadoraLimiteCredito {
    public static void main(String[] args){
        CalculadoraLimiteCredito calculadora = new CalculadoraLimiteCredito("3151", 28289, 32000, 0, 28888);

        System.out.println("El usuario con numero de cuenta " + calculadora.getNumeroCuenta());
        System.out.println("Tiene un limite de credito de: " + calculadora.getLimiteCredito());

        int nuevoSaldo = calculadora.nuevoSaldo();

        System.out.println("Su saldo a fin de mes es: " + nuevoSaldo);

        if(calculadora.isExceed(nuevoSaldo))
            System.out.println("Se excedio el limite de su credito");
    }
}
