package com.qudopro.ch21;

public class ListTest {
    public static void main(String[] args){
        List<Integer> list = new List<>();

        //insert
        list.insertAtFront(-1);
        list.print();
        list.insertAtFront(0);
        list.print();

        list.insertAtBack(43);
        list.print();
        list.insertAtBack(5);
        list.print();

        //Remove
        try{
            int removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();
        }catch (EmptyListException e){
            e.printStackTrace();
        }
    }
}
