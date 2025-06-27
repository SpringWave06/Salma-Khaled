package com.pioneers.functionalprogramming.registration.service;

@FunctionalInterface
public interface FailureCallback {

    void onFailure(String message);
}
