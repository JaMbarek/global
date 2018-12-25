package com.cloud.mvc.example.business.domain.enums;

public enum  Role {

    USER("user"),
    ADMIN("admin")

    ;

    private String name;

    Role(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
