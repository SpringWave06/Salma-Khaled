package com.pioneers.refactor.util.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CatStrategy implements Animal {

    @Override
    public String getAnimalName() {
        return "cat";
    }

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
