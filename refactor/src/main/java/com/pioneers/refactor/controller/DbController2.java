package com.pioneers.refactor.controller;

import com.pioneers.refactor.config.StudentProperties;
import com.pioneers.refactor.util.singleton.DbConnectionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("db2")
public class DbController2 {

    private final DbConnectionBean dbConnection;

    private final StudentProperties studentProperties;

    @Autowired
    public DbController2(DbConnectionBean dbConnection, StudentProperties studentProperties) {
        this.studentProperties = studentProperties;
        System.out.println("DbController2 constructor");
        this.dbConnection = dbConnection;
    }

    @GetMapping("getPasswordAndUserName")
    public String getPasswordApi() {
        return dbConnection.getPassword() + " / " + studentProperties.getUserName();
    }
}
