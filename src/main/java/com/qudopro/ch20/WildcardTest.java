package com.qudopro.ch20;

import java.util.ArrayList;

public class WildcardTest {
    public static void main(String[] args){
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5};
        Integer[] integers = {1,2,3,4,5,6};
        Number[] numbers = {1,2.4,3,4.1};

        ArrayList<Integer> integerList = new ArrayList<>();
        ArrayList<Double> doubleList = new ArrayList<>();
        ArrayList<Number> numberList = new ArrayList<>();

        for(Integer i : integers)
            integerList.add(i);


        System.out.println("NumberList contains: " + integerList);
        System.out.printf("Total of the elements in Number List: %.1f%n", sum(integerList));

        for(Double d : doubles)
            doubleList.add(d);

        System.out.println("NumberList contains: " + doubleList);
        System.out.printf("Total of the elements in Number List: %.1f%n", sum(doubleList));

        for(Number n : numbers)
            numberList.add(n);

        System.out.println("NumberList contains: " + numberList);
        System.out.printf("Total of the elements in Number List: %.1f%n", sum(numberList));
    }

    private static double sum(ArrayList<? extends Number> list){
        double total = 0;
        for(Number n : list)
            total += n.doubleValue();

        return total;
    }

}
