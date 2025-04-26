package com.pioneers.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
public class CarController {

    private final Car car;

    public CarController() {
        car = new Car("Mercides", 2025, new Engine("Germany"));
    }

    @GetMapping("start")
    public void startBmwApi() {
        car.startEngine();
    }

    @GetMapping("drive")
    public void driveBmwApi() {
        car.drive();
    }

    @GetMapping("stop")
    public void stopBmwApi() {
        car.stopEngine();
    }

    @GetMapping("model")
    public String getModelBmwApi() {
        return car.getModel();
    }

    @GetMapping("manufacturingYear")
    public Integer getManufacturingYearBmwApi() {
        return car.getManufacturingYear();
    }

    @GetMapping("engineNationality")
    public String getEngineNationalityBmwApi() {
        return car.getEngine().getEngineNationality();
    }

}
