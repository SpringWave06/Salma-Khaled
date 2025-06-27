package com.pioneers.functionalprogramming.registration.service;

@FunctionalInterface
public interface SuccessCallback<T> {

    void onSuccess(T element);
}
