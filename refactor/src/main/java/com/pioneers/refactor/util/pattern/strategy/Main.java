package com.pioneers.refactor.util.pattern.strategy;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(new CatStrategy(), new DogStrategy(), new LionStrategy(), new DonkeyStrategy());

        feedAnimal(animals);
    }

    private static void feedAnimal(List<Animal> animals) {
        animals.forEach(Animal::feed);
    }
}
