package com.pioneers.refactor.util.pattern.singleton;

public class DbConnectionThreadSafe {
    private String url = "jdbc://localhost:3306/db";
    private String username = "root";
    private String password = "123";

    private static DbConnectionThreadSafe dbConnection;

    private DbConnectionThreadSafe() {
    }

    public static synchronized DbConnectionThreadSafe getInstance() {
        if (dbConnection == null) {
            dbConnection = new DbConnectionThreadSafe();
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
