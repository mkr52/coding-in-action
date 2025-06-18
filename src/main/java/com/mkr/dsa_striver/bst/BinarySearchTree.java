package com.mkr.dsa_striver.bst;

public class BinarySearchTree {

    Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public BinarySearchTree(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }

    public BinarySearchTree() {
        root = null; // keep the root null; although redundant, as it is initialized to null be default
    }
}
