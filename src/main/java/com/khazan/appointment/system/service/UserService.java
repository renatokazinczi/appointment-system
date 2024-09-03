package com.khazan.appointment.system.service;

import com.khazan.appointment.system.dto.UserDto;
import com.khazan.appointment.system.dao.model.user.User;
import com.khazan.appointment.system.dao.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(UserAssembler::toDto)
                .toList();
    }
}
