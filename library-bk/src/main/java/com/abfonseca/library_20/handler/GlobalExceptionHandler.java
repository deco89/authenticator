package com.abfonseca.library_20.handler;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.mail.MessagingException;

@RestControllerAdvice
public class GlobalExceptionHandler {    

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ExceptionResponse> handleException(LockedException exp) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ExceptionResponse.builder()
                .businessErrorCode(BusinessErrorCodes.ACCOUNT_LOCKED.getCode())
                .businessErrorDescription(BusinessErrorCodes.ACCOUNT_LOCKED.getDescription())
                .error(exp.getMessage())
                .build());        
    };

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ExceptionResponse> handleException(DisabledException exp) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ExceptionResponse.builder()
                .businessErrorCode(BusinessErrorCodes.ACCOUNT_DISABLED.getCode())
                .businessErrorDescription(BusinessErrorCodes.ACCOUNT_DISABLED.getDescription())
                .error(exp.getMessage())
                .build());        
    };

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleException(BadCredentialsException exp) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ExceptionResponse.builder()
                .businessErrorCode(BusinessErrorCodes.BAD_CREDETIALS.getCode())
                .businessErrorDescription(BusinessErrorCodes.BAD_CREDETIALS.getDescription())
                .error(BusinessErrorCodes.BAD_CREDETIALS.getDescription())
                .build());        
    };

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ExceptionResponse> handleException(MessagingException exp) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionResponse.builder()
                .error(exp.getMessage())
                .build());        
    };

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException exp) {
        Set<String> errors = new HashSet<>();
        exp.getBindingResult().getAllErrors()
            .forEach(error -> {
                var errorMessage = error.getDefaultMessage();
                errors.add(errorMessage);
            });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ExceptionResponse.builder()
                .validationErrors(errors)
                .build());        
    };

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exp) {        
        //log the exception
        exp.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionResponse.builder()
                .businessErrorDescription("Erro interno, contacte o administrador")
                .error(exp.getMessage())
                .build());        
    };

}