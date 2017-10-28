package com.github.synk.webfluxdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Value;

@ControllerAdvice
public class DemoControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiError exception(Exception exception) {
        return new ApiError(exception.getMessage());
    }

    @Value
    public static class ApiError {
        private final String message;
    }
}
