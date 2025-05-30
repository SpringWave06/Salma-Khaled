package com.pioneers.refactor.util.pattern.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DonkeyStrategy implements Animal {
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
