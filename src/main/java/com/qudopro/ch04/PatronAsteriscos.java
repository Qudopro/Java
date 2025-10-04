package com.qudopro.ch04;

public class PatronAsteriscos {
    public static void main(String[] args){
        for(int i = 1; i <=  8; i++){
            for (int j = 1; j <= 8; j++){
                if(i % 2 == 1)
                    System.out.print("* ");
                else {
                    if(j == 1)
                        System.out.print(" ");
                    System.out.print("* ");

                }
            }
            System.out.println();
        }
    }
}
