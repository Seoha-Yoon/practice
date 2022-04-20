package com.example.practice.exceptions;

import org.hibernate.hql.internal.ast.ErrorReporter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ItemExceptionHandler {
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse unknownError(Throwable throwable){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "0000", throwable.getMessage());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse reportError(ItemNotFoundException exception){
        return new ErrorResponse(HttpStatus.NOT_FOUND, "0001", exception.getMessage());
    }
}
