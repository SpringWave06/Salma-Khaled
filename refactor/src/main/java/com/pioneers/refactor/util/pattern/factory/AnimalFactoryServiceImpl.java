package com.pioneers.refactor.util.pattern.factory;

import org.springframework.stereotype.Component;

@Component
public class AnimalFactoryServiceImpl implements AnimalFactoryService {

    @Override
    public Animal returnAnimal(TheAnimal animal) {
        return switch (animal) {
            case CAT -> new CatStrategy();
            case DOG -> new DogStrategy();
            case LION -> new LionStrategy();
            case DONKEY -> new DonkeyStrategy();
        };
    }
}
