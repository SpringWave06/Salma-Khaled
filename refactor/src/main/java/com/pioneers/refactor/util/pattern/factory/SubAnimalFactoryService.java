package com.pioneers.refactor.util.pattern.factory;

public class SubAnimalFactoryService extends AnimalFactoryServiceImpl {

    public void feedAnimal(Animal animal) {
        animal.feed();
    }

    public void sleepAnimal(Animal animal) {
        animal.sleep();
    }
}
