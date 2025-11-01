package com.khazan.appointment.system.controller;

import com.khazan.appointment.system.dto.AuthenticationRequestDto;
import com.khazan.appointment.system.dto.AuthenticationResponse;
import com.khazan.appointment.system.dto.RegisterDto;
import com.khazan.appointment.system.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            //@RequestBody @Valid RegisterDto registerDto
    ) {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequestDto authenticationRequestDto
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestDto));
    }
}
