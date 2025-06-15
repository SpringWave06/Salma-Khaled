package com.pioneers.service.error.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Thrown when student not found in a repository
 *
 * @author Abdelaziz Said
 */
@Value
@EqualsAndHashCode(callSuper = false)
public class StudentNotFoundException extends RuntimeException {

    int code = 1000;
    String description;

    public StudentNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }

    public StudentNotFoundException(String message, Throwable cause, String description) {
        super(message, cause);
        this.description = description;
    }
}
