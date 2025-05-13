package com.mkr.dsa_striver.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedListDemo myLinkedList = new LinkedListDemo(1);
        myLinkedList.append(4);
        myLinkedList.append(3);
        myLinkedList.removeLast();
        myLinkedList.prepend(0);
        myLinkedList.removeFirst();

        myLinkedList.set(1, 10);

        myLinkedList.insert(2, 30);
        myLinkedList.insert(2, 20);

        myLinkedList.remove(1);

        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.println("Item at index (" + i + "): " + myLinkedList.get(i).value);
        }

        myLinkedList.printList();
        myLinkedList.reverse();
        System.out.println("After reversing the linked list: ");
        myLinkedList.printList();

    }
}
