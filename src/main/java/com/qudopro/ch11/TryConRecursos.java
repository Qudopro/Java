package com.qudopro.ch11;

import java.util.Scanner;

public class TryConRecursos {
    public static void main(String[] args){
        try(Scanner entrada = new Scanner(System.in); Scanner input = new Scanner(System.in)){
            System.out.println("Inserte un valor");
            String cadena = entrada.nextLine();
            String cadena2 = input.nextLine();
            System.out.println("El valor insertado por el usuario fue: " + cadena + " y " + cadena2);
            throw new Exception("Mensaje de error personalizado");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
