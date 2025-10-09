package com.qudopro.ch06;

import java.security.SecureRandom;

public class Aleatorios2 {
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();

        System.out.println(secureRandom.nextInt(5)*2 + 2);
    }

}
