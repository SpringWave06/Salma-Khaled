package com.pioneers.refactor.util.pattern.singleton;

public class DbConnectionBillPugh {
    private String url = "jdbc://localhost:3306/db";
    private String username = "root";
    private String password = "123";

    private DbConnectionBillPugh() {
    }

    private static class DbConnectionBillPughHelper {
        private static final DbConnectionBillPugh INSTANCE = new DbConnectionBillPugh();

        private DbConnectionBillPughHelper() {
        }
    }

    public static DbConnectionBillPugh getInstance() {
        return DbConnectionBillPughHelper.INSTANCE;
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
