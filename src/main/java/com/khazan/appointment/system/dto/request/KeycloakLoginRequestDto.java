package com.khazan.appointment.system.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KeycloakLoginRequestDto(
        String username,
        String password,
        @JsonProperty("client_id")
        String client_id,
        @JsonProperty("client_secret")
        String client_secret,
        @JsonProperty("grant_type")
        String grant_type,
        String scope
) {
}
