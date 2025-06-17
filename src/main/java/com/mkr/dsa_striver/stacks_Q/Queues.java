package com.mkr.dsa_striver.stacks_Q;

public class Queues {

    public static void main(String[] args) {
        Queues queue = new Queues(5);
        queue.enqueue(29);
        queue.enqueue(7);
        queue.getFront();
        queue.getLast();
        queue.getLength();
        queue.printStack();
    }

    private Node front;
    private Node last;
    private int length;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queues(int value) {
        front = new Node(value);
        last = front;
        length = 1;
    }

    public void printStack() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getFront() {
        System.out.println("Front: " + (front != null ? front.value : "Queue is empty"));
    }

    public void getLast() {
        System.out.println("Last: " + last.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            front = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.next = null;
            last = newNode;
        }
        length++;
    }
}
