package com.siroi.assignment.domain;

import com.siroi.assignment.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Created by Mukhtiar on 11/10/2019.
 */
@Slf4j
public class ActiveAuditListener {


    @PreUpdate
    public void updateOnStatusChange(BaseEntity entity) {
        log.debug("PreUpdate {} ", entity.getClass().getSimpleName());
        if(entity.getIsActiveOldValue() != null && entity.getIsActive() != entity.getIsActiveOldValue()) {
            log.warn("The old values is {} and new value {} ", entity.getIsActiveOldValue(), entity.getIsActive());
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = ((UserDTO) authentication.getPrincipal()).getUserName();
            log.warn("modify by {} ",userName);
            if(entity.getIsActiveOldValue()) {
                entity.setDeactivatedBy(userName);
                entity.setDeactivatedOn(LocalDateTime.now());
            } else {
                entity.setReactivatedBy(userName);
                entity.setReactivatedOn(LocalDateTime.now());
            }

        }
    }
}
