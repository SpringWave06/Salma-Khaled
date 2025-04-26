package com.pioneers.spring.controller;

public class Engine {

    // Tightly Coupled
//    private String engineNationality = "United Kingdom";


    // Loosely Coupled
    private final String engineNationality;

    public Engine(String engineNationality) {
        this.engineNationality = engineNationality;
    }

    public void start() {
        System.out.println("3n3n3n3n3n3n3n3n3nnnnnnnn3nnnnnn");
    }

    public void stop() {
        System.out.println("------------------");
    }

    public void move() {
        System.out.println("voovvvvvvovooooooooooooovovooovvvvooooooooo");
    }

    public String getEngineNationality() {
        return engineNationality;
    }
}
