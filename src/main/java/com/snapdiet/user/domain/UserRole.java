package com.snapdiet.user.domain;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    public String getValue() {
        return value;
    }

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}
