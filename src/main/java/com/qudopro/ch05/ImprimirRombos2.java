package com.qudopro.ch05;

import java.util.Scanner;

public class ImprimirRombos2 {
    public static void main(String[] arsg){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese un digito entre 1 y 19 y te mostrare un rombo con esas dimensiones:\t\t");
        int dato = entrada.nextInt();
        int minimum = 0;
        int minimumImpar = 2;
        int maximumSpaces = dato/2;
        int minimumSpaces = 0;
        int minimumSpacesImpar = 1;

        //Impar data
        int rowMaximum = (int)Math.ceil((double)dato/2);

        if(dato >= 1 && dato <= 19){
            if(dato == 1)
                System.out.println("*");
            else {
                int rows = dato + 2;
                //Imprime el numero de lineas que tendra el rombo
                 for(int i = 0; i < rows; i++){
                    if(dato%2==0) {
                        //Par
                        int maximum = dato+1;
                        if (i < rows / 2) {                 //Primera mitad
                            if(maximumSpaces > 0)
                                System.out.print(" ".repeat(maximumSpaces));        //Espacios
                            System.out.println("*".repeat(i * 2 + 1));
                            maximumSpaces--;
                        }else {                             //Segunda mitad
                            if(maximum - minimum >= 1) {
                                if(i > dato/2+1)
                                    System.out.print(" ".repeat(minimumSpaces));    //Espacios
                                int numberAsteristics = maximum - minimum;
                                minimum += 2;
                                minimumSpaces++;
                                System.out.println("*".repeat(numberAsteristics));
                            }
                        }
                    }else{
                        //Impar
                        if(i <= Math.ceil((double)dato/2)){                 //Primera mitad hasta valor maximo (incluido)
                            System.out.print(" ".repeat(rowMaximum-i));
                            System.out.println("*".repeat(i*2+1));
                        }else{
                            if(i > rowMaximum)
                                System.out.print(" ".repeat(minimumSpacesImpar));
                            int maximum = dato+2;
                            int numberAsteristics = maximum - minimumImpar;
                            minimumImpar+=2;
                            minimumSpacesImpar++;
                            System.out.println("*".repeat(numberAsteristics));
                        }
                    }
                }
            }
        }
    }
}