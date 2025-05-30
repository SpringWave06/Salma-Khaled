package com.pioneers.refactor.util.pattern.factory;

import java.util.Optional;

public enum TheAnimal {
    CAT,
    DOG,
    LION,
    DONKEY;

    public static Optional<TheAnimal> fromString(String animal) {
        for (TheAnimal theAnimal : TheAnimal.values()) {
            if (theAnimal.name().equalsIgnoreCase(animal)) {
                return Optional.of(theAnimal);
            }
        }
        return Optional.empty();
    }
}
