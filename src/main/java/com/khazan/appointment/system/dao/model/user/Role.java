package com.khazan.appointment.system.dao.model.user;

import java.util.Arrays;

public enum Role {

    USER,
    ADMIN;

    public static Role fromString(String role) {
        return Arrays.stream(Role.values())
                .filter(c -> c.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow();
    }
}
