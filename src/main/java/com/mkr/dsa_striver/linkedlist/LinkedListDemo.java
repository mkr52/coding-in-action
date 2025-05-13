package com.mkr.dsa_striver.linkedlist;

import org.w3c.dom.Node;

public class LinkedListDemo {

    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return size;
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedListDemo(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    // Append a new node
    public void append(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // Remove last
    public Node removeLast() {
        if(head == null) {
            return null;
        }
        Node temp = head;
        Node prev = head;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        size--;
        if(size == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    // Prepend a new node
    public void prepend(int value) {
        Node newNode = new Node(value);

        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    // remove first
    public Node removeFirst() {
        if(head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
        if(size == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp == null) {
            return false;
        } else {
            temp.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > size) {
            return false;
        }
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == size) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        if(index == 0) {
            return removeFirst();
        }
        if(index == size - 1) {
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        size--;
        return temp;
    }

    // reverse the linked list
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i = 0; i < size; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
