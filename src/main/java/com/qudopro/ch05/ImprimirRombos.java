package com.qudopro.ch05;

public class ImprimirRombos {
    public static void main(String[] args){
        for(int i = 1; i < 10; i++){
            for(int j = 1; j <= 9; j++){
                if(i == 1 || i == 9){
                    if(j == 5)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                if(i == 2 || i == 8)
                    if(j>3 && j < 7)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                if(i == 3 || i == 7)
                    if(j > 2 && j < 8)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                if(i == 4 || i == 6)
                    if(j > 1 && j < 9)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                if(i == 5)
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}

/*
     *
    ***
   *****
  *******
 *********

 */
