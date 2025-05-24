package com.pioneers.refactor.util.pattern.singleton;

public class DbConnectionEager {
    private String url = "jdbc://localhost:3306/db";
    private String username = "root";
    private String password = "123";

    private static final DbConnectionEager DB_CONNECTION = new DbConnectionEager();

    public DbConnectionEager() {
    }

    public static DbConnectionEager getInstance() {
        return DB_CONNECTION;
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
