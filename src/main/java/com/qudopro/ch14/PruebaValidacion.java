package com.qudopro.ch14;

import java.util.Scanner;

public class PruebaValidacion {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escriba un nombre:\t");
        String nombre = entrada.nextLine();
        System.out.print("\nEscriba un apellido:\t");
        String apellido = entrada.nextLine();
        System.out.print("\nEscriba una direccion:\t");
        String direccion = entrada.nextLine();
        System.out.print("\nEscriba una ciudad:\t");
        String ciudad = entrada.nextLine();
        System.out.print("\nEscriba un estado:\t");
        String estado = entrada.nextLine();
        System.out.print("\nEscriba un codigo postal:\t");
        String cp = entrada.nextLine();
        System.out.print("\nEscriba un telefono:\t");
        String telefono = entrada.nextLine();

        System.out.println("Validacion de entrada");
        System.out.println(ValidacionEntrada.validarNombre(nombre));
        System.out.println(ValidacionEntrada.validarApellido(apellido));
        System.out.println(ValidacionEntrada.validarDireccion(direccion));
        System.out.println(ValidacionEntrada.validarCiudad(ciudad));
        System.out.println(ValidacionEntrada.validarEstado(estado));
        System.out.println(ValidacionEntrada.validarCodigoPostal(cp));
        System.out.println(ValidacionEntrada.validarTelefono(telefono));

    }
}
