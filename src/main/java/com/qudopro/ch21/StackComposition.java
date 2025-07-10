package com.qudopro.ch21;

public class StackComposition<T> {
    private List<T> stackList;

    public StackComposition(){
        stackList = new List<T>("stack");
    }

    //Add Object to Stack
    public void push(T object){
        stackList.insertAtFront(object);
    }

    //Remove Object from stack
    public T pop() throws EmptyListException{
        return stackList.removeFromFront();
    }

    //Determina si la lista esta vacia
    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    //Output stack contents
    public void print(){
        stackList.print();
    }
}
