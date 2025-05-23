package com.pioneers.refactor.controller;

import com.pioneers.refactor.config.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

    private final StudentProperties studentProperties;

    @Autowired
    public WelcomeController(StudentProperties studentProperties) {
        this.studentProperties = studentProperties;
    }

    @GetMapping("student")
    public String welcomeKhaledApi() {
        StudentProperties.Address address = studentProperties.getAddress();

        return "Name: " + studentProperties.getUserName() + ", Age: " + studentProperties.getAge() +
                ", Email: " + studentProperties.getEmail() + ", Address: " + address.getContinent() + "/" +
                address.getCountry() + "/" + address.getGovernorate() + "/" + address.getCity() + "/" +
                address.getStreet() + "/" + address.getBuildingNumber() + "/" + address.getFloor() + "/" +
                address.getApartmentNumber();
    }
}
