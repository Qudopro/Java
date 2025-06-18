package com.qudopro.ch06;

import java.security.SecureRandom;

public class TirarDado20Veces {
    public static void main(String[] args){
        SecureRandom secure = new SecureRandom();

        for(int i = 1; i <= 20; i++){
            int cara = 1 + secure.nextInt(6);

            System.out.printf("%d\s", cara);

            if(i % 5 == 0)
                System.out.println();
        }

    }
}
