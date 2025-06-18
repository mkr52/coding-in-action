package com.mkr.dsa_striver.bst;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();
        myBST.insert(4);
        myBST.insert(3);
        myBST.insert(5);
        System.out.println("Root = " + (myBST.root != null ? myBST.root.value : "Null (Empty tree) !"));
    }
}
