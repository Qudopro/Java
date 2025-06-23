package com.qudopro.ch16;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args){
        //Cola con una capacidad inicial de 11 elementos
        PriorityQueue<Double> priority = new PriorityQueue<>();

        //Agregar elementos en la cola
        priority.offer(3.2);
        priority.offer(4.43);
        priority.offer(1.3);

        System.out.println("Sondenado la cola");
        //Imprimir los elementos
        while(priority.size() > 0){
            System.out.printf("%.1f  ", priority.peek());
            priority.poll();
        }
    }
}
