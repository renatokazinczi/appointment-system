package com.khazan.appointment.system.client;

import com.khazan.appointment.system.config.KeycloakProperties;
import com.khazan.appointment.system.dto.AuthenticationRequestDto;
import com.khazan.appointment.system.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Component
public class KeycloakClient {

    private final KeycloakProperties keycloakProperties;
    @Qualifier("keycloakRestClient")
    private final RestClient restClient;

    public AuthenticationResponse authenticate(
            AuthenticationRequestDto authenticationRequestDto
    ) {
            return restClient.post()
                    .uri(createLoginUri())
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(getAuthRequestBody(authenticationRequestDto))
                    .retrieve()
                    .toEntity(AuthenticationResponse.class)
                    .getBody();
    }

    private String createLoginUri() {
        return "/realms/" + keycloakProperties.getRealm() + "/protocol/openid-connect/token";
    }

    private MultiValueMap<String, String> getAuthRequestBody(AuthenticationRequestDto authenticationRequestDto) {
        return MultiValueMap.fromSingleValue(Map.of(
                "grant_type", "password",
                "username", authenticationRequestDto.username(),
                "password", authenticationRequestDto.password(),
                "scope", "openid",
                "client_id", keycloakProperties.getClientId(),
                "client_secret", keycloakProperties.getClientSecret()
        ));
    }
}
