package com.pioneers.refactor.util.pattern.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CatStrategy implements Animal {

    @Override
    public void feed() {
        log.info("Cat is eating dry food");
    }

    @Override
    public void sleep() {
        log.info("ssssssssssssss");
    }

    @Override
    public void walk() {
        log.info("Cat is walking!!");
    }
}
