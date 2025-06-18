package com.qudopro.ch05;

public class ModificarVariableControlFor {
    public static void main(String[] args){
        for(int i = 1; i <= 10; i++){
            System.out.printf("%d\s", i);
        }
        System.out.println();
        for(int i = 10; i >= 1; i--){
            System.out.printf("%d\s", i);
        }
        System.out.println();
        for(int i = 7; i <= 70; i+=7){
            System.out.printf("%d\s", i);
        }
        System.out.println();
        for(int i = 2; i <= 20; i+=3){
            System.out.printf("%d\s", i);
        }
    }

}
