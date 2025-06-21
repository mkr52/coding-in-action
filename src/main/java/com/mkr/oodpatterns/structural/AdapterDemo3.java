package com.mkr.oodpatterns.structural;

public class AdapterDemo3 {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.quack();
        duck.fly();

        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);
        droneAdapter.quack();
        droneAdapter.fly();
    }
}

interface Drone {
    public void beep();
    public void spin_rotors();
    public void take_off();
}

class SuperDrone implements Drone {

    @Override
    public void beep() {
        System.out.println("Beep! Beep!");
    }

    @Override
    public void spin_rotors() {
        System.out.println("Rotors are spinning!");
    }

    @Override
    public void take_off() {
        System.out.println("Taking off!");
    }
}


class DroneAdapter implements Duck {

    Drone drone;

    public DroneAdapter(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void quack() {
        drone.beep();
    }

    @Override
    public void fly() {
        drone.spin_rotors();
        drone.take_off();
    }
}
