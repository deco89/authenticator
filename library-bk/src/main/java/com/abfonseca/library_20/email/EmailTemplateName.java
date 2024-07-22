package com.abfonseca.library_20.email;

import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("activate_account");


    private final String name;
    EmailTemplateName(String name) {
        this.name = name;
    }
}
