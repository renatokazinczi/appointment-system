package com.khazan.appointment.system.service.role;

import com.khazan.appointment.system.dao.model.user.Role;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PermissionChecker {

    @SneakyThrows
    @Around(value = "@annotation(permissionCheck)")
    public Object hasRole(
            final ProceedingJoinPoint joinPoint,
            final PermissionCheck permissionCheck
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SimpleGrantedAuthority authority = (SimpleGrantedAuthority) authentication.getAuthorities().stream().toList().get(0);

        Role userRole = Role.fromString(authority.getAuthority());
        Role requiredRole = permissionCheck.value();

        if (userRole.equals(requiredRole)) {
            return joinPoint.proceed();
        } else {
            throw new AccessDeniedException("Access denied!");
        }
    }
}
