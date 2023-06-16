package com.example.promocodeService.exception;

public enum ExceptionType {
    VALIDATION_ERROR(400),
    NO_RESULT(404),
    CONFLICT(409),
    TOO_MANY_REQUESTS(429),
    ERROR(500);

    private final Integer statusCode;

    ExceptionType(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
