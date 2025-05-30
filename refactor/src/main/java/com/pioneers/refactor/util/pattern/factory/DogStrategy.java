package com.pioneers.refactor.util.pattern.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DogStrategy implements Animal {

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
