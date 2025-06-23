package com.qudopro.ch16;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args){
        Stack<Number> stack = new Stack<>();

        //Meter elementos en la pila
        stack.push(12L);
        System.out.println("Se ha metido un valor en la pila");
        imprimirPila(stack);

        stack.push(34567);
        System.out.println("Se ha metido un valor en la pila");
        imprimirPila(stack);

        stack.push(1.0F);
        System.out.println("Se ha metido un valor en la pila");
        imprimirPila(stack);

        stack.push(1234.5678);
        System.out.println("Se ha metido un valor en la pila");
        imprimirPila(stack);
        System.out.println();
        //Eliminar elementos en la pila
        try{
            Number objetoEliminado = null;

            while(true){
                System.out.println("Se sacara de la pila el siguiente elemento: " + stack.peek());
                objetoEliminado = stack.pop();
                System.out.println("Se ha sacado un elemento en la pila: " + objetoEliminado);
                imprimirPila(stack);
            }
        }catch(EmptyStackException e){
            e.printStackTrace();
        }
    }

    private static void imprimirPila(Stack<Number> pila){
        if(pila.isEmpty())
            System.out.println("La pila esta vacia");
        else
            System.out.printf("La pila contiene: %s (cima)\n", pila);
    }

}
