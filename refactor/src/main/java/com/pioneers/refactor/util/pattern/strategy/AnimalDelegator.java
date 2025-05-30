package com.pioneers.refactor.util.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalDelegator {

    private final List<Animal> animals;

    @Autowired
    public AnimalDelegator(List<Animal> animals) {
        this.animals = animals;
    }

    public void feed(String animalName) {
        animals.stream()
                .filter(animal -> isNameMatched(animal.getAnimalName(), animalName))
                .findFirst()
                .ifPresent(Animal::feed);
    }

    public void sleep(String animalName) {
        animals.stream()
                .filter(animal -> isNameMatched(animal.getAnimalName(), animalName))
                .findFirst()
                .ifPresent(Animal::sleep);
    }



    // TODO: Move the following method to the proper utility class.
    private boolean isNameMatched(String sourceAnimalName, String targetAnimalName) {
        return sourceAnimalName.equalsIgnoreCase(targetAnimalName);
    }
}
