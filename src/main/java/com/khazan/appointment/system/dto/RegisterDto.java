package com.khazan.appointment.system.dto;

import com.khazan.appointment.system.dao.model.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String firstname;

    private String lastname;
    private String email;
    private String password;
    private Role role;
}
