package com.mkr.oodpatterns.behavioral;

class VegetarianPizza extends Pizza {

    @Override
    public void addToppings() {
        System.out.println("Add cheese, tomato, mushrooms, peppers and olives" );
    }

}

class MeatFeastPizza extends Pizza {

    @Override
    public void addToppings() {
        System.out.println("Add pepperoni, ham and chicken" );
    }
}

abstract class Pizza {
    public void makeBase() {
        System.out.println("Mix flour, yeast and salt.");
        System.out.println("Roll out the dough.");
    }

    public abstract void addToppings();

    public void cook() {
        System.out.println("Cook in the oven for 20 minutes");
    }
}

public class TemplateChallenge {
    public static void main(String[] args) {
        var vegetarianPizza = new VegetarianPizza();
        vegetarianPizza.makeBase();
        vegetarianPizza.addToppings();
        vegetarianPizza.cook();

        var meatFeastPizza = new MeatFeastPizza();
        meatFeastPizza.makeBase();
        meatFeastPizza.addToppings();
        meatFeastPizza.cook();
    }
}
