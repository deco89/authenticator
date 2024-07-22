package com.abfonseca.library_20.handler;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public enum BusinessErrorCodes {

    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "No code"),
    INCORRECT_CURRENT_PASSWORD(300, HttpStatus.BAD_REQUEST, "Senha incorreta"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, HttpStatus.BAD_REQUEST, "Senhas não combinam"),
    ACCOUNT_LOCKED(302, HttpStatus.FORBIDDEN, "Conta do usuário bloqueada"),
    ACCOUNT_DISABLED(303, HttpStatus.FORBIDDEN, "Conta do usuário está desativada"),
    BAD_CREDETIALS(304, HttpStatus.FORBIDDEN, "Login e/ou senha está incorreto");




    @Getter
    private final Integer code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httStatus;

    private BusinessErrorCodes(Integer code, HttpStatus status, String description) {
        this.code = code;
        this.description = description;
        this.httStatus = status;
    }


    

    

}
