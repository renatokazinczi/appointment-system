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
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class PermissionChecker {

    @SneakyThrows
    @Around(value = "@annotation(permissionCheck)")
    public Object hasRole(
            final ProceedingJoinPoint joinPoint,
            final PermissionCheck permissionCheck
    ) {
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        List<Role> userRoles = mapClaimsToUserRoles(authentication.getTokenAttributes());
        Role requiredRole = permissionCheck.value();

        boolean hasRole = userRoles.stream()
                .anyMatch(role -> role.equals(requiredRole));

        if (hasRole) {
            return joinPoint.proceed();
        } else {
            throw new AccessDeniedException("Access denied!");
        }
    }

    //TODO gányolás
    private List<Role> mapClaimsToUserRoles(Map<String, Object> roles) {
        List<Role> userRoles = new ArrayList<>();
        for (String role : (List<String>) roles.get("role")) {
            userRoles.add(Role.fromString(role));
        }
        return userRoles;
    }
}
