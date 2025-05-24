package com.pioneers.refactor.controller;

import com.pioneers.refactor.config.StudentProperties;
import com.pioneers.refactor.util.pattern.singleton.DbConnectionBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("db2")
public class DbController2 {

    private final DbConnectionBean dbConnection;

    private final StudentProperties studentProperties;

    @Autowired
    public DbController2(DbConnectionBean dbConnection, StudentProperties studentProperties) {
        this.studentProperties = studentProperties;
        this.dbConnection = dbConnection;
        log.trace("dbConnection and studentProperties are injected inside the DbController2");
    }

    @GetMapping("getPasswordAndUserName")
    public String getPasswordApi() {
        return dbConnection.getPassword() + " / " + studentProperties.getUserName();
    }
}
