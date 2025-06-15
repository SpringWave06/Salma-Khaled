package com.pioneers.service.error;

import com.pioneers.service.error.exception.AuthenticationException;
import com.pioneers.service.error.exception.StudentNotFoundException;
import com.pioneers.service.error.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.pioneers.service.util.TimeUtils.currentTimestamp;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        e.getAllErrors().forEach(error -> {
            String description = error.getDefaultMessage();
            String message = ((FieldError) error).getField();
            errors.add(message);
            descriptions.add(description);
        });
        return new ResponseEntity<>(
                new ErrorResponse(10, errors, descriptions, currentTimestamp()), HttpStatus.OK);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException e) {
        ErrorResponse errorResponse =
                new ErrorResponse(e.getCode(), e.getMessage(), e.getDescription(), currentTimestamp());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException e) {
        ErrorResponse errorResponse
                = new ErrorResponse(e.getCode(), e.getMessage(), e.getDescription(), currentTimestamp());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }
}
