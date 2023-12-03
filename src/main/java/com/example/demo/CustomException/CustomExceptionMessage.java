package com.example.demo.CustomException;

import lombok.Getter;


@Getter
public class CustomExceptionMessage extends RuntimeException {

    private final int statusCode;
    private final String message;

    public CustomExceptionMessage(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}


