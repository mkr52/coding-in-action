package com.mkr.oodpatterns.behavioral;

// Memento class
class PriceMemento {
    private int state;

    public PriceMemento(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

class StoreItem {
    private int price;
    private PriceMemento memento = new PriceMemento(price);

    public StoreItem(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void save() {
        memento.setState(price);
    }

    public void restore() {
        price = memento.getState();
    }
}
public class MementoChallenge {

    public static void main(String[] args) {

        StoreItem item = new StoreItem(20);
        System.out.println("Item price is: " + item.getPrice());
        item.save();
        item.setPrice(10);
        System.out.println("Item price is: " + item.getPrice());
        item.restore();
        System.out.println("Restored item price is: " + item.getPrice());
    }
}
