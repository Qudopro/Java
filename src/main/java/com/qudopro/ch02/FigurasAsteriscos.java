package com.qudopro.ch02;

public class FigurasAsteriscos {
    public static void main(String[] args){
        String nineAsteristics = "*".repeat(9);
        String oneAsteristics = "*";
        String threeAsteristics = "*".repeat(3);
        String fiveAsteristics = "*".repeat(5);


        System.out.printf("%9s%8s%8s%9s%n", nineAsteristics, threeAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%s%8s%4s%6s%7s%7s%2s%n", oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics,threeAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%s%8s%3s%8s%7s%5s%4s%n", oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics,fiveAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%s%8s%3s%8s%5s%6s%6s%n", oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%s%8s%3s%8s%5s%5s%8s%n", oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%s%8s%3s%8s%5s%6s%6s%n", oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%s%8s%3s%8s%5s%7s%4s%n", oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%s%8s%4s%6s%6s%8s%2s%n", oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics,oneAsteristics, oneAsteristics, oneAsteristics);
        System.out.printf("%9s%8s%8s%9s%n", nineAsteristics, threeAsteristics, oneAsteristics, oneAsteristics);
    }
}
