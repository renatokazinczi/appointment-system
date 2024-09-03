package com.khazan.appointment.system.service.role;

import com.khazan.appointment.system.dao.model.user.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PermissionCheck {

    Role value();
}
