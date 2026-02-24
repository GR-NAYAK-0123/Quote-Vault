package com.raja.quote_vault.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class QuoteControllerAdvice {

    @ExceptionHandler(QuoteNotFoundException.class)
    public ResponseEntity<?> handleQuoteNotFoundException(QuoteNotFoundException qnf){
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), qnf.getMessage(), "404-Quote Not Found");
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(Exception e){
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in Execution");
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
