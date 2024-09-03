package com.khazan.appointment.system.service;

import com.khazan.appointment.system.dto.UserDto;
import com.khazan.appointment.system.dao.model.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserAssembler {

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .externalId(user.getExternalId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .archived(user.getArchived())
                .role(user.getRole())
                .build();
    }
}
