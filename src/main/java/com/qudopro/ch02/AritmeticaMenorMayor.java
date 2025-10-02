package com.qudopro.ch02;
import java.util.Scanner;
public class AritmeticaMenorMayor {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba el primer numero:\t");
        int numero1 = entrada.nextInt();

        System.out.print("Escriba el segundo numero:\t");
        int numero2 = entrada.nextInt();

        System.out.print("Escriba el tercer numero:\t");
        int numero3 = entrada.nextInt();

        int menor = numero1;
        if(menor > numero2)
            menor = numero2;
        if(menor > numero3)
            menor = numero3;

        int mayor = numero1;
        if(mayor < numero2)
            mayor = numero2;
        if(mayor < numero3)
            mayor = numero3;

        int suma = numero1 + numero2 + numero3;
        int promedio = (numero1+numero2+numero3)/3;

        System.out.printf("Operaciones con los numeros introducidos: %d, %d y %d:%n" +
                        "%s\t%d%n%s\t%d%n%s\t%d%n%s\t%d%n",
                numero1, numero2, numero3, "Suma:", suma, "Promedio:", promedio, "El menor numero:", menor, "El mayor numero:", mayor);

    }
}
