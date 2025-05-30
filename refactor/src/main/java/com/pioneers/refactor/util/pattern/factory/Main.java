package com.pioneers.refactor.util.pattern.factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the animal code: ");
        String animalName = scanner.next();

        AnimalFactoryService animalFactoryService = new AnimalFactoryServiceImpl();

        TheAnimal.fromString(animalName)
                .ifPresent(theAnimal -> {
                    Animal animal = animalFactoryService.returnAnimal(theAnimal);
                    animal.feed();
                    animal.sleep();
                    animal.walk();
                });
    }
}
