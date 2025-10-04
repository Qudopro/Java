package com.qudopro.ch04;

public class SalidaTabular {
    public static void main(String[] args){
        System.out.printf("%-10s%-10s%-10s%-10s%n", "N", "10*N", "100*N", "1000*N");
        for(int i = 1; i <= 5; i++){
            System.out.printf("%-10d%-10d%-10d%-10d%n", i, i*10, i*100, i*1000);
        }
    }
}
