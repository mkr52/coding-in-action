package com.mkr.dsa_striver.hashtable;

public class HashTable {
    private int size = 7; // initial size of the hash table
    private Node[] dataMap;

    static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null; // next is initialized to null by default
        }
    }

    public HashTable() {
        this.dataMap = new Node[size];
    }

    // Print hash table
    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println("Index " + i + ": ");
            Node temp = dataMap[i];
            while(temp != null) {
                System.out.println(" Key: " + temp.key + " Value: " + temp.value);
                temp = temp.next;
            }
        }
    }

//    private int hash(String key) {
//        int hash = 0;
//        for (char c : key.toCharArray()) {
//            hash += c; // simple hash function, can be improved
//        }
//        return hash % size; // ensure the hash is within the bounds of the array
//    }
}
