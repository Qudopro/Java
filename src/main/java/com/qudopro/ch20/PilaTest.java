package com.qudopro.ch20;

public class PilaTest {
    public static void main(String[] args){
        double[] doubles = {1.1,2.2,3.3,4.4,5.5};
        int[] integers = {1,2,3,4,5,6};

        Pila<Double> doublePila = new Pila<>(5);
        Pila<Integer> integerPila = new Pila<>(6);

        testPushDouble(doublePila, doubles);
        testPopDouble(doublePila);

        testPushInteger(integerPila, integers);
        testPopInteger(integerPila);
    }

    private static void testPushDouble(Pila<Double> stack, double[] doubles){
        System.out.println("Pushing elements onto double stack");

        for(double d : doubles){
            System.out.printf("%.1f ", d);
            stack.push(d);
        }
        System.out.println();
    }

    private static void testPopDouble(Pila<Double> stack){
        System.out.println("Popping elements from double stack");
        try{
            double popValue;
            while(true){
                popValue = stack.pop();
                System.out.printf("%.1f ", popValue);
            }
        }catch(EmptyStackException e){
            System.err.println();
            e.printStackTrace();
        }
        System.out.println();
    }
    private static void testPushInteger(Pila<Integer> stack, int[] integers){
        System.out.println("Pushing elements onto integer stack");

        for(int i : integers){
            System.out.printf("%d ", i);
            stack.push(i);
        }
        System.out.println();
    }

    private static void testPopInteger(Pila<Integer> stack){
        System.out.println("Popping elements from double stack");
        try{
            int popValue;
            while(true){
                popValue = stack.pop();
                System.out.printf("%d ", popValue);
            }
        }catch(EmptyStackException e){
            System.err.println();
            e.printStackTrace();
        }
        System.out.println();
    }
}
