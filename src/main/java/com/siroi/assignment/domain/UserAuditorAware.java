package com.siroi.assignment.domain;

import com.siroi.assignment.dto.UserDTO;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * Created by Mukhtiar on 11/9/2019.
 */
public class UserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.ofNullable(null);
        }

        String userName = ((UserDTO) authentication.getPrincipal()).getUserName();
        return Optional.of(userName);
    }
}
