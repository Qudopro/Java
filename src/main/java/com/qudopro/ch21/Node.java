package com.qudopro.ch21;

public class Node<T> {
    private T data;
    private Node<T> nextNode;               //Referencia al siguiente nodo. Objeto de la misma clase

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
