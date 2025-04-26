package com.pioneers.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

    @GetMapping("hamza")
    public String welcomeHamzaApi() {
        return "<h1>Welcome Hamza to Tech Pioneers Hub!</h1>";
    }
}
