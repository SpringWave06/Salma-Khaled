package com.pioneers.service.error.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class AuthenticationException extends RuntimeException {

    int code = 2000;
    String description;

    public AuthenticationException(String message, String description) {
        super(message);
        this.description = description;
    }
}
