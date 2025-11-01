package com.khazan.appointment.system.service;

import com.khazan.appointment.system.client.KeycloakClient;
import com.khazan.appointment.system.dto.AuthenticationRequestDto;
import com.khazan.appointment.system.dto.AuthenticationResponse;
import com.khazan.appointment.system.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final KeycloakClient keycloakClient;

    public AuthenticationResponse register(RegisterDto registerDto) {
        return null;
    }

    public AuthenticationResponse authenticate(
            AuthenticationRequestDto authenticationRequestDto
    ) {
        return keycloakClient.authenticate(authenticationRequestDto);
    }
}
