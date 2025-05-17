package com.pioneers.refactor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationContextController {

    private final AppContext appContext;

    public ApplicationContextController() {
        appContext = new AppContext();
    }

    @PutMapping("changeAppContext/{port}/{host}/{dbUrl}/{dbUser}")
    public void changeAppContextApi(
            @PathVariable Integer port,
            @PathVariable String host,
            @PathVariable String dbUrl,
            @PathVariable String dbUser
    ) {
        appContext.setPort(port);
        appContext.setHost(host);
        appContext.setDbUrl(dbUrl);
        appContext.setDbUser(dbUser);
    }

    @PutMapping("changeAppContext/{dbPassword}")
    public void changeAppContextApi(@PathVariable String dbPassword) {
        appContext.setDbPassword(dbPassword);
    }

    @GetMapping("findAppContext")
    public AppContext findAppContextApi() {
        return appContext;
    }

}
