package com.qudopro.ch21;

class TreeNode<T extends Comparable<T>>{
    TreeNode<T> leftNode;
    TreeNode<T> rightNode;
    T data;                                     //Node Value

    public TreeNode(T nodeData){
        data = nodeData;
        leftNode = rightNode = null;                    //Node has no children
    }

    //Locate insertion point and insert new node. Ignore duplicate values
    public void insert(T insertValue){
        //Insert in left subtree
        if(insertValue.compareTo(data) < 0){
            //Insert new TreeNode
            if(leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else
                leftNode.insert(insertValue);           //Continue traversing left subtree recursively
        }//Insert in right node
        else if(insertValue.compareTo(data) > 0){
            if(rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else
                rightNode.insert(insertValue);           //Continue traversing left subtree recursively
        }
    }
}

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public Tree(){
        root = null;                                //Inicializa un árbol vacío
    }

    //Insert a new node in the binary search tree
    public void insertNode(T insertValue){
        if(root == null)
            root = new TreeNode<T>(insertValue);                //Create root node
        else
            root.insert(insertValue);
    }

    //Begin preorder traversal.     Obtiene el valor de todos los nodos en el orden en el que son visitados
    public void preorderTraversal(){
        preorderHelper(root);
    }

    //Recursive method to perform preorder traversal. Procesa el valor del nodo. Recorre el subarbol izquierdo y luego recorre el subarbol derecho
    private void preorderHelper(TreeNode<T> node){
        if(node == null)
            return;

        System.out.printf("%s ", node.data);                //Output node data

        preorderHelper(node.leftNode);                      //Traverse left node
        preorderHelper(node.rightNode);                     //Traverse right subtree
    }
    //InOrder -> Orden ascendente
    //Begin inorder traversal. Se procesan los valores de los nodos hasta que los valores de los nodos del subarbol izquierdo son procesados
    public void inorderTraversal(){
        inorderHelper(root);
    }

    //Recursive method to perform inorder traversal. Recorre el subarbol izquierdo, procesa valores y recorre el subarbol derecho
    private void inorderHelper(TreeNode<T> node){
        if(node == null)
            return;

        inorderHelper(node.leftNode);                      //Traverse left node
        System.out.printf("%s ", node.data);                //Output node data
        inorderHelper(node.rightNode);                     //Traverse right subtree
    }


    //Begin postorder traversal.Se procesan todos los nodos y luego los imprime
    public void postorderTraversal(){
        postorderHelper(root);
    }

    //Recursive method to perform postorder traversal.  Recorre el nodo izquierdo. Luego recorre el subarbol derecho y procesa el valor
    private void postorderHelper(TreeNode<T> node){
        if(node == null)
            return;

        postorderHelper(node.leftNode);                      //Traverse left node
        postorderHelper(node.rightNode);                     //Traverse right subtree
        System.out.printf("%s ", node.data);                //Output node data
    }
}
