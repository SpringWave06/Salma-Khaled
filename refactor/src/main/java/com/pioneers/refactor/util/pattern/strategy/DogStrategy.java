package com.pioneers.refactor.util.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DogStrategy implements Animal {

    @Override
    public String getAnimalName() {
        return "dog";
    }

    @Override
    public void feed() {
        log.info("Dog is eating dry food");
    }

    @Override
    public void sleep() {
        log.info("5oo5oo5ooo5oooo");
    }

    @Override
    public void walk() {
        log.info("Dog is walking!!");
    }
}
