package com.qudopro.ch21;

import java.security.SecureRandom;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        SecureRandom secureRandom = new SecureRandom();

        System.out.println("Inserting the following values");

        for(int i = 1; i <= 10; i++){
            int value = secureRandom.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal: %n");
        tree.preorderTraversal();
        System.out.printf("%nInorder traversal: %n");
        tree.inorderTraversal();
        System.out.printf("%nPostorder traversal: %n");
        tree.postorderTraversal();
    }
}
