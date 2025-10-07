package com.qudopro.ch05;

public class ImprimirTriangulo {
    public static void main(String[] args){
        for(int i = 0; i < 4; i++){
            for(int j = 1; j<= 10; j++){
                switch(i){
                    case 0:
                        System.out.print("*".repeat(j));
                        System.out.println();
                        break;
                    case 1:
                        System.out.print("*".repeat(11 - j));
                        System.out.println();
                        break;
                    case 2:
                        System.out.print(" ".repeat(j-1));
                        System.out.print("*".repeat(11 - j));
                        System.out.println();
                        break;
                    case 3:
                        System.out.print(" ".repeat(11-j));
                        System.out.print("*".repeat(j));
                        System.out.println();
                        break;
                }
            }

            System.out.println("\n\n");
        }
    }
}
