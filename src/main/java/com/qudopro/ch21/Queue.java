package com.qudopro.ch21;

public class Queue<T> {
    private List<T> queueList;

    public Queue(){
        queueList = new List<T>("queue");
    }

    //Push elements to Queue
    public void enqueue(T object){
        queueList.insertAtBack(object);
    }

    //Remove objects from Queue
    public T dequeue(){
        return queueList.removeFromFront();
    }

    //Determina si Queue esta vacio
    public boolean isEmpty(){
        return queueList.isEmpty();
    }

    //Output queue contents
    public void print(){
        queueList.print();
    }
}
