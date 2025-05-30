package com.pioneers.refactor.util.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LionStrategy implements Animal {
    @Override
    public String getAnimalName() {
        return "lion";
    }

    @Override
    public void feed() {
        log.info("Lion is eating the goat");
    }

    @Override
    public void sleep() {
        log.info("Lion is sleeping");
    }

    @Override
    public void walk() {
        log.info("Lion is walking");
    }
}
