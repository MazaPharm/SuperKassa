package com.example.superkasssa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity handleException(NoSuchElementException e) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body("Error Message");
    }
}
