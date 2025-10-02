package com.qudopro.ch02;
import java.util.Scanner;
public class EnterosMenorMayor {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba cinco digitos:");
        int numero1 = entrada.nextInt();
        int numero2 = entrada.nextInt();
        int numero3 = entrada.nextInt();
        int numero4 = entrada.nextInt();
        int numero5 = entrada.nextInt();

        int mayor = numero1;
        int menor = numero1;

        if(mayor < numero2)
            mayor = numero2;
        if(mayor < numero3)
            mayor = numero3;
        if(mayor < numero4)
            mayor = numero4;
        if(mayor < numero5)
            mayor = numero5;

        if(menor > numero2)
            menor = numero2;
        if(menor > numero3)
            menor = numero3;
        if(menor > numero4)
            menor = numero4;
        if(menor > numero5)
            menor = numero5;
        System.out.printf("El mayor numero introducido fue: %d%nEl menor numero introducido fue: %d", mayor, menor);

    }
}
