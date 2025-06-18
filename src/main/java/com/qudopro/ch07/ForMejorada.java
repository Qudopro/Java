package com.qudopro.ch07;

public class ForMejorada {
    public static void main(String[] args){
        int[] respuestas = {1,2,3,4,5,5,4,3,2,1,1,2,3,4,5,5,4,3,2,1,10};
        int total = 0;

        for(int i : respuestas)
            total += i;

        System.out.println(total);

    }
}
