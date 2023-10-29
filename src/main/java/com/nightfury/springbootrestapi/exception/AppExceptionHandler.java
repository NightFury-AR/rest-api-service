package com.nightfury.springbootrestapi.exception;


import com.nightfury.springbootrestapi.exception.type.AppException;
import com.nightfury.springbootrestapi.exception.type.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionBody> handleMethodArgumentException(MethodArgumentNotValidException e) {
        String errorResult = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " - " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(","));

        return parseException(
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST,
                errorResult,
                "VALIDATION_ERROR"
        );
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionBody> handleValidationException(ValidationException e) {
        return parseException(
                e.getCode(),
                HttpStatus.BAD_REQUEST,
                e.getLocalizedMessage(),
                e.getInstance()
        );
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ExceptionBody> handleAppException(AppException e) {
        return parseException(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getLocalizedMessage(),
                e.getInstance()
        );
    }

    private ResponseEntity<ExceptionBody> parseException(String code, HttpStatus status , String instance , String message) {
        return new ResponseEntity<ExceptionBody>(new ExceptionBody(code,status,message,instance),status);
    }
}
