package com.mkr.oodpatterns.behavioral;

import java.util.ArrayList;

public class ObserverDemo3 {

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        UserInterface ui = new UserInterface(station);
        LoggerObserver logger = new LoggerObserver(station);
        AlertObserver alert = new AlertObserver(station);
        station.removeObserver(logger);

        // simulate weather updates
        station.setMeasurements(25, 10, 1013);
        station.setMeasurements(29, 15, 1012);
        station.setMeasurements(35, 15, 1010);

    }
}

interface WeatherStationSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObserver();
}

interface WeatherObserver {
    void update(int temperature, int humidity, int pressure);
}

class UserInterface implements WeatherObserver {
    private int temperature;
    private int humidity;
    private int pressure;
    private WeatherStation weatherStation;

    public UserInterface(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "°C, " + humidity + "% humidity, " + pressure + " hPa pressure.");
    }
}

class LoggerObserver implements WeatherObserver {
    private int temperature;
    private int humidity;
    private int pressure;
    private WeatherStation weatherStation;

    public LoggerObserver(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        log();
    }

    public void log() {
        System.out.println("Logged conditions: " + temperature + "°C, " + humidity + "% humidity, " + pressure + " hPa pressure.");
    }
}

class AlertObserver implements WeatherObserver {
    private int temperature;
    private int humidity;
    private int pressure;
    private WeatherStation weatherStation;

    public AlertObserver(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        checkAlertConditions();
    }

    public void checkAlertConditions() {
        if (temperature > 30) {
            System.out.println("Alert: High temperature detected! " + temperature + "°C.");
        }
        if (humidity > 80) {
            System.out.println("Alert: High humidity detected! " + humidity + "%.");
        }
        if (pressure < 1000) {
            System.out.println("Alert: Low pressure detected! " + pressure + " hPa.");
        }
    }
}

class WeatherStation implements WeatherStationSubject {
    private ArrayList<WeatherObserver> observers;
    private int temperature;
    private int windSpeed;
    private int humidity;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(WeatherObserver observer: observers) {
            observer.update(temperature, windSpeed, humidity);
        }
    }
    public void setMeasurements(int temperature, int windSpeed, int humidity) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        notifyObserver();
    }
}

