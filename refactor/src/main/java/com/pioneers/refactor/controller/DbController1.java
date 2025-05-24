package com.pioneers.refactor.controller;

import com.pioneers.refactor.util.pattern.singleton.DbConnectionBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("db1")
public class DbController1 {

    private final DbConnectionBean dbConnection;

    // Constructor Injection by Autowired
    @Autowired
    public DbController1(DbConnectionBean dbConnection) {
        log.trace("I am instantiating DbController1 inside the Application Context");
        this.dbConnection = dbConnection;
        log.trace("dbConnection is injected inside DbController1");
    }

    // Setter Injection by Autowired
    /*@Autowired
    public void setDbConnection(DbConnectionBean dbConnection) {
        this.dbConnection = dbConnection;
    }

    // Field Injection
    @Autowired
    private DbConnectionBean dbConnection;*/

    @PostMapping("connect")
    public void connectApi() {
        dbConnection.connect();
    }

    @PostMapping("changePassword/{password}")
    public void changePasswordApi(@PathVariable String password) {
        dbConnection.setPassword(password);
    }
}
