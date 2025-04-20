package com.pioneers.datastructures.functionalinterface;

@FunctionalInterface
public interface SendService {
    void send(String message, String from, String to);
}
