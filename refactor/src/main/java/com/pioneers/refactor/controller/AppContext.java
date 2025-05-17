package com.pioneers.refactor.controller;

import java.util.Objects;

public class AppContext {
    private int port = 8080;
    private String host = "192.168.0.100";
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppContext that = (AppContext) o;
        return port == that.port &&
                Objects.equals(host, that.host) &&
                Objects.equals(dbUrl, that.dbUrl) &&
                Objects.equals(dbUser, that.dbUser) &&
                Objects.equals(dbPassword, that.dbPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port, host, dbUrl, dbUser, dbPassword);
    }

    @Override
    public String toString() {
        return "AppContext{" +
                "dbUser='" + dbUser + '\'' +
                ", dbUrl='" + dbUrl + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
