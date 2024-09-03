package com.khazan.appointment.system.dao.repository.user;

import com.khazan.appointment.system.dao.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
