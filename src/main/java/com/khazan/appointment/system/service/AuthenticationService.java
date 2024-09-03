package com.khazan.appointment.system.service;

import com.khazan.appointment.system.dao.model.user.UserRole;
import com.khazan.appointment.system.dto.AuthenticationRequest;
import com.khazan.appointment.system.dto.AuthenticationResponse;
import com.khazan.appointment.system.dto.RegisterDto;
import com.khazan.appointment.system.dao.model.user.User;
import com.khazan.appointment.system.dao.repository.user.UserRepository;
import com.khazan.appointment.system.service.jwt.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticationResponse register(RegisterDto registerDto) {
        UserRole role = UserRole.builder()
                .role(registerDto.getRole())
                .build();
        User user = User.builder()
                .firstname(registerDto.getFirstname())
                .lastname(registerDto.getLastname())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .role(role)
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        User user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email=" + authenticationRequest.getEmail()));
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
