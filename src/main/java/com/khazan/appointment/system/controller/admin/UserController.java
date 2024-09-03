package com.khazan.appointment.system.controller.admin;

import com.khazan.appointment.system.dto.UserDto;
import com.khazan.appointment.system.service.UserService;
import com.khazan.appointment.system.dao.model.user.Role;
import com.khazan.appointment.system.service.role.PermissionCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @PermissionCheck(Role.ADMIN)
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }
}
