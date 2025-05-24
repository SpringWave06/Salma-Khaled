package com.pioneers.refactor.util.pattern.singleton;

public enum DbConnectionEnum {
    INSTANCE;

    private String url = "jdbc://localhost:3306/db";
    private String username = "root";
    private String password = "123";

    public static DbConnectionEnum getInstance() {
        return INSTANCE;
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
