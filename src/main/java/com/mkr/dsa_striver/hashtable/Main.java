package com.mkr.dsa_striver.hashtable;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("apple", 1);
        hashTable.set("banana", 2);
        hashTable.set("orange", 3);
        hashTable.set("chikki", 4);
        hashTable.set("pine", 6);
        hashTable.set("jamun", 7);
        hashTable.printTable();
        System.out.println(hashTable.get("jamun"));
    }
}
