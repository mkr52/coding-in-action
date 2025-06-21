package com.mkr.oodpatterns.structural;

public class AdapterDemo2 {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        testDuck(duck);
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey); // TurkeyAdapter implements the Duck interface
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}

interface Duck {
    void quack();
    void fly();
}

class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Mallard duck quacks");
    }

    @Override
    public void fly() {
        System.out.println("Mallard duck flies.");
    }
}

interface Turkey {
    void gobble();
    void fly();
}
class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Wild turkey gobbles");
    }

    @Override
    public void fly() {
        System.out.println("Wild turkey flies a short distance.");
    }
}

class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        for(int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
