package com.pioneers.refactor.controller;

import com.pioneers.refactor.util.pattern.strategy.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("strategy")
public class AnimalStrategyController {

    private final List<Animal> animals;

    @Autowired
    public AnimalStrategyController(List<Animal> animals) {
        this.animals = animals;
    }

    @PostMapping("animal")
    public void feedAnimalApi() {
        animals.forEach(Animal::feed);
    }
}
