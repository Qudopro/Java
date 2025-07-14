package com.qudopro.ch23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args){
        //Create & Name each runnable
        PrintTask t1 = new PrintTask("Task 1");
        PrintTask t2 = new PrintTask("Task 2");
        PrintTask t3 = new PrintTask("Task 3");
        PrintTask t4 = new PrintTask("Task 4");

        System.out.println("Starting Executor");

        //Create ExecutorService to manage threads
        ExecutorService eS = Executors.newCachedThreadPool();

        //Start the PrintTask
        eS.execute(t1);
        eS.execute(t2);
        eS.execute(t3);
        eS.execute(t4);

        //Shut down ExecutorService
        eS.shutdown();

        System.out.printf("Tasks started. Method main ends%n%n");
    }
}

/*
synchronized(Object object){ }
Donde object es el objeto que adquirirá el monitor lock. Es this si es el mismo objeto que la clase en la que aparece.
 */
