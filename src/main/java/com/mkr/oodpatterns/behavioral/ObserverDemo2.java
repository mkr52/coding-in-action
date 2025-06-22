package com.mkr.oodpatterns.behavioral;

import java.util.ArrayList;

public class ObserverDemo2 {

    public static void main(String[] args) {
        SimpleSubject simpleSubject = new SimpleSubject();
        SimpleObserver simpleObserver = new SimpleObserver(simpleSubject);

        simpleSubject.setValue(10);
        simpleSubject.setValue(20);
        simpleSubject.setValue(30);

        // Display the current value in the observer
        System.out.println(" -- Current value in observer --");
        simpleObserver.display();

    }
}

interface Subject2 {
    public void registerObserver(Observer2 observer2);
    public void removeObserver(Observer2 observer2);
    public void notifyObservers();
}

interface Observer2 {
    public void update(int value);
}

class SimpleObserver implements Observer2 {
    private int value;
    private SimpleSubject simpleSubject;

    public SimpleObserver(SimpleSubject simpleSubject) {
        this.simpleSubject = simpleSubject;
        simpleSubject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        this.value = value;
        display();
    }

    public void display() {
        System.out.println("Value: " + value);
    }
}

class SimpleSubject implements Subject2 {
    private ArrayList<Observer2> observers;
    private int value = 0; // state

    public SimpleSubject() {
        observers = new ArrayList<Observer2>();
    }

    @Override
    public void registerObserver(Observer2 observer2) {
        observers.add(observer2);
    }

    @Override
    public void removeObserver(Observer2 observer2) {
        observers.remove(observer2);
    }

    @Override
    public void notifyObservers() {
        for (Observer2 observer: observers) {
            observer.update(value);
        }
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}
