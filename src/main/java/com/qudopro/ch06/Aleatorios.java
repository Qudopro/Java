package com.qudopro.ch06;

import java.security.SecureRandom;

public class Aleatorios {
    public static void main(String[] args){
        SecureRandom secure = new SecureRandom();


        for(int i = 0; i < 10; i++)
            System.out.println(secure.nextInt(2) + 1);

        System.out.println();

        for(int i = 0; i < 10; i++)
            System.out.println(secure.nextInt(101) + 1);


        System.out.println();

        for(int i = 0; i < 10; i++)
            System.out.println(secure.nextInt(10));

        System.out.println();

        for(int i = 0; i < 10; i++)
            System.out.println(secure.nextInt(14) - 3);

    }
}
