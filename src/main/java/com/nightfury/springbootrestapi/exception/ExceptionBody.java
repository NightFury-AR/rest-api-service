package com.nightfury.springbootrestapi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionBody {
    private String code;
    private HttpStatus status;
    private String message;
    private String instance;
}
