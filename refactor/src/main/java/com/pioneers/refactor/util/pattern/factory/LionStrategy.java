package com.pioneers.refactor.util.pattern.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LionStrategy implements Animal {
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
