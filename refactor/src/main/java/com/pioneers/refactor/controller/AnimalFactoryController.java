package com.pioneers.refactor.controller;

import com.pioneers.refactor.util.pattern.factory.AnimalFactoryService;
import com.pioneers.refactor.util.pattern.factory.TheAnimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("factory")
public class AnimalFactoryController {

    private final AnimalFactoryService animalFactoryService;

    @Autowired
    public AnimalFactoryController(AnimalFactoryService animalFactoryService) {
        this.animalFactoryService = animalFactoryService;
        log.trace("Injected animalFactoryService into AnimalFactoryController");
    }

    @PostMapping("feedAnimal/{animal}")
    public void feedAnimalApi(@PathVariable("animal") String animal) {
        TheAnimal.fromString(animal)
                .ifPresent(theAnimal -> animalFactoryService.returnAnimal(theAnimal).feed());
    }

}
