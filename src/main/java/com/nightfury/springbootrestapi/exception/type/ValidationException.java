package com.nightfury.springbootrestapi.exception.type;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private String code;
    private String instance;
    public ValidationException(String message, String code, String instance) {
        super(message);
        this.code = code;
        this.instance = instance;
    }

}
