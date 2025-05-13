package com.mkr.oodpatterns.structural;

interface Room {
    void printFurniture();
}

class BasicRoom implements Room {
    @Override
    public void printFurniture() {
        System.out.println("Basic room furniture: Bed, Table");
    }
}

public class DecoratorChallenge {
    public static void main(String[] args) {
        Room room = new BasicRoom();
        room.printFurniture();
    }
}
