package com.example.promocodeService.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@ControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(RestControllerExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorInfo> handleApiException(ApiException ex) {
        LOGGER.error("ApiException has been handled. Exception message: {}", ex.getMessage());
        return new ResponseEntity<>(new ErrorInfo(new Date(), ex.getStatus().getStatusCode(), ex.getMessage()),
                HttpStatus.valueOf(ex.getStatus().getStatusCode()));
    }
}
