package com.mkr.oodpatterns.structural;

public class DecoratorPizzaDemo {
    public static void main(String[] args) {
        Pizza pizza = new ThickCrustPizza();
        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);

        System.out.println(pizza.getDescription() + " $" + pizza.cost());
    }
}

abstract class Pizza {
    String description = "Unknown Pizza";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

class ThinCrustPizza extends Pizza {
    public ThinCrustPizza() {
        description = "Thin Crust Pizza";
    }

    @Override
    public double cost() {
        return 4.59;
    }
}

class ThickCrustPizza extends Pizza {
    public ThickCrustPizza() {
        description = "Thick Crust Pizza";
    }

    @Override
    public double cost() {
        return 4.29;
    }
}

abstract class ToppingsDecorator extends Pizza {
    public abstract String getDescription();
}

class Cheese extends ToppingsDecorator {
    Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double cost() {
        return pizza.cost() + 0.99;
    }
}

class Olives extends ToppingsDecorator {
    Pizza pizza;

    public Olives(Pizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double cost() {
        return pizza.cost() + 0.79;
    }
}
