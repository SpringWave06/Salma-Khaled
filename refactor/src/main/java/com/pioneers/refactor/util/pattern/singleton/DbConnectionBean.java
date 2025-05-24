package com.pioneers.refactor.util.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbConnectionBean {

    private static final String CLASS_NAME = DbConnectionBean.class.getSimpleName();

    private String url;
    private String username;
    private String password;

    public DbConnectionBean(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

        log.trace("dbConnectionBean object is initialized into the Application Context");
    }

    public void connect() {
        final String methodName = "connect()";
        Object[] args = new Object[]{methodName, url, username, password};
        log.info("{}, Connecting to database... to URL: {}, username: {}, password: {}", args);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
