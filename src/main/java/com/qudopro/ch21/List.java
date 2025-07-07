package com.qudopro.ch21;

class ListNode<T>{
    //Package access members
    T data;                             //Data for this node
    ListNode<T> nextNode;               //Reference to the next node in the list. Null if is the last node

    ListNode(T object){
        this(object, null);
    }

    //Constructor para 1 objeto y un nodo
    ListNode(T object, ListNode<T> node){
        data = object;
        nextNode = node;
    }

    //Return reference to data in node
    public T getData() {
        return data;
    }

    //Return reference to nextNode in list
    public ListNode<T> getNextNode() {
        return nextNode;
    }
}

public class List<T>{
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name;

    public List(){
        this("List");
    }

    public List(String listName){
        name = listName;
        firstNode = lastNode = null;                //Inicializa ambas referencias a null
    }

    public void insertAtFront(T insertItem){
        if(isEmpty())               //First and last node refer to the same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else
            firstNode = new ListNode<T>(insertItem, firstNode);
    }

    public void insertAtBack(T insertItem){
        if(isEmpty())
            firstNode = lastNode = new ListNode<T>(insertItem);
        else
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
    }

    public T removeFromFront() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException(name);

        T removedItem = firstNode.data;

        //Obtiene el siguiente elemento
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem;
    }

    public T removeFromBack() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException(name);

        T removedItem = lastNode.data;

        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else{
            ListNode<T> current = firstNode;

            while(current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current;
            current.nextNode = null;
        }

        return removedItem;
    }

    //Determina si la lista esta vacía
    public boolean isEmpty(){
        return firstNode == null;                   //Return true if list is empty
    }

    //Output list contents
    public void print(){
        if(isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is ", name);
        ListNode<T> current = firstNode;

        while(current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }
}
