package com.qudopro.ch05;

public class ImprimirTriangulos2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for(int j = 0; j < 4; j++){
                switch(j){
                    case 0:
                        System.out.printf("%-14s", "*".repeat(i));
                        break;
                    case 1:
                        System.out.printf("%-14s","*".repeat(11 - i));
                        break;
                    case 2:
                        System.out.printf("%14s", "*".repeat(11 - i));
                        break;
                    case 3:
                        System.out.printf("%14s","*".repeat(i));
                }
            }

            System.out.println();
        }
    }
}
