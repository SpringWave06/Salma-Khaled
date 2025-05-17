package com.pioneers.refactor.controller;

import com.pioneers.refactor.util.singleton.DbConnectionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("db2")
public class DbController2 {

    private DbConnectionBean dbConnection;

    @PostMapping("getPassword")
    public String changePasswordApi() {
        return dbConnection.getPassword();
    }

    @Autowired(required = false)
    public void setDbConnection(DbConnectionBean dbConnection) {
        System.out.println("getPassword Setter injection!!");
        this.dbConnection = dbConnection;
    }
}
