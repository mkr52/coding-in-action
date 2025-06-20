package com.mkr.dsa_striver.hashtable;

import java.util.ArrayList;

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

    private int hash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += c * 23;
        }
        return hash % dataMap.length; // ensure the hash is within the bounds of the array
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if(temp.key.equalsIgnoreCase(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0; // return 0 if key is not found
    }

    // keys
    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++){
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }
}
