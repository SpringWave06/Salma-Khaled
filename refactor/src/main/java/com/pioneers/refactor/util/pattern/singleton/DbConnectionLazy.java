package com.pioneers.refactor.util.pattern.singleton;

public class DbConnectionLazy {
    private String url = "jdbc://localhost:3306/db";
    private String username = "root";
    private String password = "123";

    private static DbConnectionLazy dbConnection;

    private DbConnectionLazy() {
    }

    public static DbConnectionLazy getInstance() {
        if (dbConnection == null) {
            dbConnection = new DbConnectionLazy();
        }
        return dbConnection;
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
