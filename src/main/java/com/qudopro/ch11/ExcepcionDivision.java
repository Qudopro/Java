package com.qudopro.ch11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcepcionDivision {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        boolean continuar = true;
        do {
            try {
                System.out.print("Introduzca el valor para \"x\":");
                int x = scanner.nextInt();
                System.out.print("Introduzca el valor para \"y\":");
                int y = scanner.nextInt();

                int resultado = cociente(x, y);
                System.out.printf("%n%d/%d\s=\s%d%n", x, y, resultado);
                continuar = false;
            }catch(ArithmeticException e){
                System.err.printf("%nExcepcion: %s%n", e);
                System.out.println("No es valido realizar la division entre 0");
            }catch(InputMismatchException e){
                System.err.printf("%nExcepcion: %s%n", e);
                scanner.nextLine();         //Descarta la linea y vuelve a intentar recuperar la informacion
                System.out.println("Debe introducir solo numeros enteros");
            }
        }while(continuar);
    }

    public static int cociente(int x, int y) throws ArithmeticException {
        return x/y;
    }
}
