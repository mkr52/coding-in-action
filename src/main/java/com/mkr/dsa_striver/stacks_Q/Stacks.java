package com.mkr.dsa_striver.stacks_Q;

public class Stacks {

    public static void main(String[] args) {
        Stacks stack = new Stacks(4);
        stack.push(2);
        stack.push(1);
        stack.pop();
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

    // Similar to prepend in LL
    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top; // link the new node to the current top
            top = newNode; // update top to the new node
        }
        height++;
    }

    public Node pop() {
        if(height == 0) {
            System.out.println("Stack is empty, cannot pop.");
            return null;
        }
        Node poppedNode = top; // store the current top node;
        top = top.next;
        poppedNode.next = null;
        height--;
        return poppedNode;
    }
}
