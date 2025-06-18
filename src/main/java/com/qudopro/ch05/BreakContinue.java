package com.qudopro.ch05;

public class BreakContinue {
    public static void main(String[] args){
        for(int i = 0; i <= 10; i++){
            if(i == 5)
                break;

            System.out.printf("%d\s", i);
        }

        System.out.println();

        for(int i = 0; i <= 10; i++){
            if(i == 5)
                continue;

            System.out.printf("%d\s", i);
        }
    }
}
