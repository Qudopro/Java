package com.qudopro.ch03;

import java.util.Scanner;

public class PruebaBancaria {
    public static void main(String[] args){
        //Creación de un objeto Cuenta
        Cuenta cuentaBase = new Cuenta();
        Cuenta cuentaAlternativa = new Cuenta("Cabrera");
        Cuenta cuentaAlternativa2 = new Cuenta("Cabrera", 23.0);

        mostrarCuenta(cuentaBase);
        mostrarCuenta(cuentaAlternativa);
        mostrarCuenta(cuentaAlternativa2);

    }

    public static void mostrarCuenta(Cuenta cuenta){
        Scanner entrada = new Scanner(System.in);

        if(cuenta.obtenerNombre() == null || cuenta.obtenerNombre().isEmpty()){
            System.out.print("Establezca un nombre en la cuenta:\t");
            String nombre = entrada.nextLine();
            cuenta.establecerNombre(nombre);
        }

        System.out.println("La cuenta pertenece a: " + cuenta.obtenerNombre());
        System.out.printf("La cuenta tiene un saldo de: $%,.2f%n", cuenta.obtenerSaldo());

        System.out.print("Escriba la cantidad a depositar en la cuenta:\t");
        double montoDeposito = entrada.nextDouble();

        System.out.println("\nAgregando el deposito en la cuenta... Por favor, espere");
        cuenta.depositar(montoDeposito);

        System.out.printf("\nAhora la cuenta tiene: $%,.2f%n", cuenta.obtenerSaldo() );


        //Retiro de dinero
        System.out.println("Cuanto desea retirar:\t");
        double montoRetiro = entrada.nextDouble();

        cuenta.retirar(montoRetiro);

        if(montoRetiro < cuenta.obtenerSaldo())
            System.out.printf("Se ha efectuado el retiro. Ahora usted tiene: $%,.2f%n", cuenta.obtenerSaldo());

        System.out.println("\\n\\n");
    }
}
