package com.pioneers.refactor.util.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DonkeyStrategy implements Animal {

    @Override
    public String getAnimalName() {
        return "donkey";
    }

    @Override
    public void feed() {
        log.info("Donkey is eating Grass");
    }

    @Override
    public void sleep() {
        log.info("Sleeping!!!!");
    }

    @Override
    public void walk() {
        System.out.println("Donkey is walking!!");
    }
}
