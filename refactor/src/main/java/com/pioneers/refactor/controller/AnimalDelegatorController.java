package com.pioneers.refactor.controller;

import com.pioneers.refactor.util.pattern.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("delegator")
public class AnimalDelegatorController {

    private final AnimalDelegator animalDelegator;

    @Autowired
    public AnimalDelegatorController(AnimalDelegator animalDelegator) {
        this.animalDelegator = animalDelegator;
    }

    @PostMapping("feedAnimal/{animalName}")
    public void feedAnimalApi(@PathVariable String animalName) {
        animalDelegator.feed(animalName);
    }
}
