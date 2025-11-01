package com.khazan.appointment.system.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequestDto(
        @NotNull
        String username,
        @NotNull
        String password
) {
}
