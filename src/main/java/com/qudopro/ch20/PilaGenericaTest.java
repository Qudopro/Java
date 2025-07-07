package com.qudopro.ch20;

public class PilaGenericaTest {
    public static void main(String[] args){
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5};
        Integer[] integers = {1,2,3,4,5,6};

        Pila<Double> doublePila = new Pila<>(5);
        Pila<Integer> integerPila = new Pila<>(6);

        testPush(doublePila, doubles);
        testPop(doublePila);

        testPush(integerPila, integers);
        testPop(integerPila);
    }

    private static <T> void testPush(Pila<T> stack, T[] elements){
        System.out.println("Pushing elements onto stack");

        for(T d : elements){
            System.out.printf("%s ", d);
            stack.push(d);
        }

        System.out.println();
    }

    private static <T> void testPop(Pila<T> stack){
        System.out.println("Popping elements from stack");
        try{
            T popValue;
            while(true){
                popValue = stack.pop();
                System.out.printf("%s ", popValue);
            }
        }catch(EmptyStackException e){
            System.err.println();
            e.printStackTrace();
        }

        System.out.println();
    }
}
