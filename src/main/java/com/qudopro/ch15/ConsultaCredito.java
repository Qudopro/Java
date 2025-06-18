package com.qudopro.ch15;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsultaCredito {
    private static final OpcionMenu[] opciones = OpcionMenu.values();
    private static String path = "/Users/dc/Downloads/";
    private static String file = "Archivo.txt";

    public static void main(String[] args){
        OpcionMenu tipoCuenta = obtenerSolicitud();

        while(tipoCuenta != OpcionMenu.FIN){
            switch (tipoCuenta){
                case SALDO_CERO:
                    System.out.println("Cuentas con saldos de cero");
                    break;
                case SALDO_CREDITO:
                    System.out.println("Cuentas con saldos con crédito");
                    break;
                case SALDO_DEBITO:
                    System.out.println("Cuentas con saldos con débito");
                    break;
            }
            leerRegistros(tipoCuenta);
            tipoCuenta = obtenerSolicitud();
        }
    }

    //Obtiene la solicitud del usuario
    private static OpcionMenu obtenerSolicitud(){
        int solicitud = 4;

        System.out.printf("Escriba Solicitud%n%s%n%s%n%s%n%s%n",
                "1.- Lista con Cuentas con saldos de cero",
                "2.- Listas de Cuentas con saldos con credito",
                "3.- Listas de Cuentas con saldos con debito",
                "4.- Terminar programa"
                );

        try{
            Scanner entrada = new Scanner(System.in);

            do {
                System.out.printf("? ");
                solicitud = entrada.nextInt();
            }while(solicitud < 1 || solicitud > 4);
        } catch (NoSuchElementException e) {
            System.err.println("Entrada no valida");
            System.exit(1);
        }

        return opciones[solicitud - 1];
    }

    //Lee los registros y muestra los registros apropiados unicamente
    private static void leerRegistros(OpcionMenu tipoCuenta) {
        //Abre el archivo y procesa el contenido
        try (Scanner entrada = new Scanner(Paths.get(path.concat(file)))) {
            int numeroCuenta = entrada.nextInt();
            String nombre = entrada.next();
            String apellido = entrada.next();
            double saldo = entrada.nextDouble();

            //Determina si el tipo de cuenta es el apropiado
            if (mostrarCuenta(tipoCuenta, saldo)) {
                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                        numeroCuenta, nombre, apellido, saldo
                );
            } else {
                entrada.nextLine();             //Descarta el registro actual
            }
        } catch (NoSuchElementException e) {
            System.err.println("Entrada no valida");
            System.exit(1);
        } catch (IllegalStateException e){
            System.err.println("Error. El archivo se ha cerrado inesperadamente");
            System.exit(1);
        }catch(IOException e){
            System.err.println("Error al procesar el archivo");
            System.exit(1);
        }
    }

    //Determina si el registro debe mostrarse
    private static boolean mostrarCuenta(OpcionMenu tipoCuenta, double saldo){
        if(tipoCuenta == OpcionMenu.SALDO_CREDITO && saldo < 0.0)
            return true;
        else if(tipoCuenta == OpcionMenu.SALDO_DEBITO && saldo > 0.0)
            return true;
        else if(tipoCuenta == OpcionMenu.SALDO_CERO && saldo == 0.0)
            return true;

        return false;
    }
}
