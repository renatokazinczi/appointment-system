package com.khazan.appointment.system.dto;

import com.khazan.appointment.system.dao.model.user.UserRole;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserDto(
        String externalId,
        String firstname,
        String lastname,
        String email,
        Boolean archived,
        UserRole role
) { }
