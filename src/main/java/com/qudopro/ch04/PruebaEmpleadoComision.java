package com.qudopro.ch04;

import java.util.Scanner;

public class PruebaEmpleadoComision {
    public static final double ARTICULO_1 = 239.99;
    public static final double ARTICULO_2 = 129.75;
    public static final double ARTICULO_3 = 99.95;
    public static final double ARTICULO_4 = 350.89;


    public static void main(String[] args){
        EmpleadoComision empleadoComision = new EmpleadoComision("3151", 200.0, 0.09);
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese -1 para dejar de escribir ventas del usuario. Ingrese cualquier otro numero para continuar");
        int validez = entrada.nextInt();

        while(validez != -1){
            System.out.print("Escriba el numero de ventas que tuvo el cliente para el articulo 1: ");
            int articulo1 = entrada.nextInt();
            System.out.print("Escriba el numero de ventas que tuvo el cliente para el articulo 2: ");
            int articulo2 = entrada.nextInt();
            System.out.print("Escriba el numero de ventas que tuvo el cliente para el articulo 3: ");
            int articulo3 = entrada.nextInt();
            System.out.print("Escriba el numero de ventas que tuvo el cliente para el articulo 4: ");
            int articulo4 = entrada.nextInt();

            double ventas = articulo1*ARTICULO_1 + articulo2*ARTICULO_2 + articulo3 * ARTICULO_3 + articulo4 * ARTICULO_4;

            double salarioFinal = empleadoComision.ingresos(ventas);

            System.out.println("Con la informacion proporcionada, el empleado recibira: " + salarioFinal);

            System.out.println("Ingrese -1 para dejar de escribir ventas del usuario. Ingrese cualquier otro numero para continuar");
            validez = entrada.nextInt();
        }

    }
}
