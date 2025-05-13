package com.mkr.oodpatterns.structural;

interface Room {
    void printDecoration();
}

class BasicRoom implements Room {
    @Override
    public void printDecoration() {
        System.out.println("Basic room furniture: Bed, Table");
    }
}

abstract class RoomDecorator implements Room {
    protected final Room room;

    public RoomDecorator(Room room) {
        this.room = room;
    }

    @Override
    public void printDecoration() {
        System.out.println("Decorating room with: ");
    }
}

class RoomWithCarpet extends RoomDecorator {

    public RoomWithCarpet(Room room) {
        super(room);
    }

    @Override
    public void printDecoration() {
        super.printDecoration();
        System.out.println("Adding carpet");
    }
}

class RoomWithChandelier extends RoomDecorator {

    public RoomWithChandelier(Room room) {
        super(room);
    }

    @Override
    public void printDecoration() {
        super.printDecoration();
        System.out.println("Adding chandelier");
    }
}

public class DecoratorChallenge {
    public static void main(String[] args) {
        Room room = new BasicRoom();
        room.printDecoration();

        Room carpetRoom = new RoomWithCarpet(room);
        carpetRoom.printDecoration();

        Room chandelierRoom = new RoomWithChandelier(new RoomWithCarpet(room));
        chandelierRoom.printDecoration();
    }
}
