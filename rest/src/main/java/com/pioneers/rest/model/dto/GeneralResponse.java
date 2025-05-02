package com.pioneers.rest.model.dto;

import java.util.Objects;

public class GeneralResponse {
    private String statusCode;
    private String message;
    private String description;

    public GeneralResponse(String statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse that = (GeneralResponse) o;
        return Objects.equals(statusCode, that.statusCode) &&
                Objects.equals(message, that.message) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, message, description);
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
