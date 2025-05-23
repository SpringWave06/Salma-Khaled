package com.pioneers.refactor.util.singleton;

public class DbConnectionBean {
    private String url;
    private String username;
    private String password;

    public DbConnectionBean(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
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
