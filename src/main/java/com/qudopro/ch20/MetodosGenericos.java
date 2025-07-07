package com.qudopro.ch20;

public class MetodosGenericos {
    public static void main(String[] args){
        Integer[] integers = {1,2,3,4,5,6};
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5,6.6};
        Character[] characters = {'a','b','c','d'};

        System.out.println("Array integers contains: ");
        printArray(integers);
        System.out.println("Array doubles contains: ");
        printArray(doubles);
        System.out.println("Array characters contains: ");
        printArray(characters);
    }

    private static <T> void printArray(T[] elements){
        for(T i : elements)
            System.out.printf("%s ", i);

        System.out.println();
    }
}
