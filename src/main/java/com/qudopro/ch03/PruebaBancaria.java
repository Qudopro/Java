package com.qudopro.ch03;

import java.util.Scanner;

public class PruebaBancaria {
    public static void main(String[] args){
        incluirSaldos();
    }

    public static void establecerNombres(){
        Scanner entrada = new Scanner(System.in);

        //Creación de un objeto Cuenta
        Cuenta cuenta = new Cuenta();
        Cuenta cuentaAlternativa = new Cuenta("Cabrera");

        System.out.printf("El nombre inicial del objeto Cuenta es: %s%n", cuenta.obtenerNombre());

        System.out.print("Establezca un nombre en el objeto:\t");
        String nombre = entrada.nextLine();
        cuenta.establecerNombre(nombre);

        System.out.println();

        System.out.printf("El nombre modificado del objeto Cuenta es: %s%n", cuenta.obtenerNombre());
        System.out.printf("El nombre modificado del objeto cuentaAlternativa es: %s%n", cuentaAlternativa.obtenerNombre());
    }

    public static void incluirSaldos(){
        Scanner entrada = new Scanner(System.in);

        Cuenta cuenta1 = new Cuenta("Cabrera", 23.0);

        System.out.printf("Saldo de %s: $%,.2f%n", cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());

        System.out.print("Escriba la cantidad a depositar en la cuenta:\t");
        double montoDeposito = entrada.nextDouble();

        System.out.println("\nAgregando el deposito en la cuenta... Por favor, espere");

        cuenta1.depositar(montoDeposito);
        System.out.printf("Saldo de %s: $%,.2f%n", cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());
    }
}
