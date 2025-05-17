package com.pioneers.refactor.util.singleton;

import org.springframework.stereotype.Component;

@Component
public class DbConnectionBean {
    private String url = "jdbc://localhost:3306/db";
    private String username = "root";
    private String password = "123";

    public DbConnectionBean() {
        System.out.println("DbConnectionBean() constructor called");
    }

    public void connect() {
        System.out.println("Connecting to " + url);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
