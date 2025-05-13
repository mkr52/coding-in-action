package com.mkr.oodpatterns.behavioral;

// Receiver
class Item {

    private final int id;

    public Item(int id) {
        this.id = id;
    }

    public void addToBasket() {
        System.out.println("Item " + id + " added to basket.");
    }

    public void removeFromBasket() {
        System.out.println("Item " + id + " removed from basket.");
    }
}

// Command
interface ItemOperation {

    void execute();
}

class AddItemToBasketOperation implements ItemOperation {

    private final Item item;

    public AddItemToBasketOperation(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        item.addToBasket();
    }
}

class RemoveItemToBasketOperation implements ItemOperation {

    private final Item item;

    public RemoveItemToBasketOperation(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        item.removeFromBasket();
    }
}

class ItemOperatorExecutor {
    public void doOperation(ItemOperation operation) {
        operation.execute();
    }
}

// Online store main
public class CommandDemo {
    public static void main(String[] args) {
        var item1 = new Item(1);
        var item2 = new Item(2);
        var item3 = new Item(3);

        var itemOperatorExecutor = new ItemOperatorExecutor();
        itemOperatorExecutor.doOperation(new AddItemToBasketOperation(item1));
        itemOperatorExecutor.doOperation(new AddItemToBasketOperation(item2));
        itemOperatorExecutor.doOperation(new AddItemToBasketOperation(item3));
        itemOperatorExecutor.doOperation(new RemoveItemToBasketOperation(item2));

//        item1.addToBasket();
//        item2.addToBasket();
//        item3.addToBasket();
//        item2.removeFromBasket();
    }
}
