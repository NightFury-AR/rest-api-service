package com.nightfury.springbootrestapi.exception.type;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private String instance;
    public AppException(String message, String instance) {
        super(message);
    }
}
