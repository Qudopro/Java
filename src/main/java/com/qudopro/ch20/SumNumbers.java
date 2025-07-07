package com.qudopro.ch20;

import java.util.ArrayList;

public class SumNumbers {
    public static void main(String[] args){
        Number[] numbers = {1,2.4,3,4.1};
        ArrayList<Number> numberList = new ArrayList<>();


        for(Number n : numbers)
            numberList.add(n);

        System.out.println("NumberList contains: " + numberList);
        System.out.printf("Total of the elements in Number List: %.1f%n", sum(numberList));
    }

    private static double sum(ArrayList<Number> list){
        double total = 0;
        for(Number n : list)
            total += n.doubleValue();

        return total;
    }
}
