package com.mkr.dsa_striver.stacks_Q;

public class Stacks {

    public static void main(String[] args) {
        Stacks stack = new Stacks(4);
        stack.getTop();
        stack.getHeight();
        stack.printStack();
    }

    private Node top;
    private int height;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stacks(int value) {
        top = new Node(value);
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + (top != null ? top.value : "Stack is empty"));
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }
}
