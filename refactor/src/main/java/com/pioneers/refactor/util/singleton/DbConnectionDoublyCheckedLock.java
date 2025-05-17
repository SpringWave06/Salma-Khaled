package com.pioneers.refactor.util.singleton;

public class DbConnectionDoublyCheckedLock {
    private String url = "jdbc://localhost:3306/db";
    private String username = "root";
    private String password = "123";

    private static DbConnectionDoublyCheckedLock dbConnection;

    private DbConnectionDoublyCheckedLock() {
    }

    public static DbConnectionDoublyCheckedLock getInstance() {
        if (dbConnection == null) {
            synchronized (DbConnectionDoublyCheckedLock.class) {
                if (dbConnection == null) {
                    dbConnection = new DbConnectionDoublyCheckedLock();
                }
            }
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
