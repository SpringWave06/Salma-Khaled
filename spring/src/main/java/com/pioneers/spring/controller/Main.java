package com.pioneers.spring.controller;

public class Main {
    public static void main(String[] args) {
        CarController carController = new CarController();
        System.out.println("carController.getModelBmwApi() = " + carController.getModelBmwApi());
    }
}
