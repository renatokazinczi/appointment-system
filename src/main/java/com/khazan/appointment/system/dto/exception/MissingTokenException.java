package com.khazan.appointment.system.dto.exception;

import lombok.RequiredArgsConstructor;

public class MissingTokenException extends RuntimeException {
    public MissingTokenException(String message) {
        super(message);
    }
}
