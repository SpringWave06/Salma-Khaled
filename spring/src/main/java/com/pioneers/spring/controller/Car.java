package com.pioneers.spring.controller;

public class Car {
    private final String model;
    private final int manufacturingYear;
    private final Engine engine;

    public Car(String model, int manufacturingYear, Engine engine) {
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.engine = engine;
    }

    public void drive() {
        engine.move();
    }

    public void startEngine() {
        engine.start();
    }

    public void stopEngine() {
        engine.stop();
    }

    public String getModel() {
        return model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public Engine getEngine() {
        return engine;
    }

}
