package com.github.kevinnowak.controller;

import com.github.kevinnowak.exception.NotEnoughMoneyException;
import com.github.kevinnowak.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        var errorDetails = new ErrorDetails("Not enough money to make the payment");

        return ResponseEntity.badRequest().body(errorDetails);
    }
}
