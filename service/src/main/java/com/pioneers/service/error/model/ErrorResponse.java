package com.pioneers.service.error.model;

import java.sql.Timestamp;

public record ErrorResponse(int code, Object message, Object description, Timestamp timestamp) {
}
