package com.qudopro.ch04;

import java.util.Scanner;

public class Cifrado {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese un valor de 4 digitos: ");
        int numero = entrada.nextInt();

        if (numero / 1000 < 10 && numero / 1000 != 0) {
            int cifra4 = numero / 1000 + 7;
            int cifra3 = numero % 1000 / 100 + 7;
            int cifra2 = numero % 100 / 10 + 7;
            int cifra1 = numero % 10 + 7;

            int nuevoValor = Integer.parseInt(String.format("%d%d%d%d", cifra4, cifra3, cifra2, cifra1));
            int residuoValor = nuevoValor%10;

            cifra4 += residuoValor;
            cifra3 += residuoValor;
            cifra2 += residuoValor;
            cifra1 += residuoValor;

            int cifraTemporal = cifra3;
            cifra3 = cifra1;
            cifra1 = cifraTemporal;

            int cifraTemporal2 = cifra4;
            cifra4 = cifra2;
            cifra2 = cifraTemporal2;

            int nuevoValorFinal = Integer.parseInt(String.format("%d%d%d%d", cifra4, cifra3, cifra2, cifra1));

            System.out.println(nuevoValorFinal);
        }
    }
}

/*
Leer un entero de 4 digitos.
Rememplazar cada digito con el resultado de sumarle 7 y obtenga el residuo después de dividir el nuevo valor entre 10
Intercambiar el primer digito con el tercero
Intercambiar el segundo digito con el cuarto
Imprimir el entero
 */