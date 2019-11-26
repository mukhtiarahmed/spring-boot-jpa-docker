/*
 * Copyright (C) 2017 Van Tibolli, All Rights Reserved.
 */
package com.siroi.assignment.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The super class of all entities of the persistence.
 *
 * @author  mukhtiar.ahmed
 * @version 1.0
 */
@Data
@MappedSuperclass
@EntityListeners({ActiveAuditListener.class, AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {

    @Column(name = "mf11_compActiveDate",  nullable = false)
    private LocalDateTime activeDate;

    @Column(name = "mf11_isActive",  nullable = false)
    private Boolean isActive;

    @CreatedDate
    @Column(name = "mf11_createdOn",  nullable = false)
    private LocalDateTime  createdOn;

    @CreatedBy
    @Column(name = "mf11_createdBy",  nullable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "mf11_lastModifiedOn")
    private LocalDateTime  lastModifiedOn;

    @LastModifiedBy
    @Column(name = "mf11_lastModifiedBy")
    private String lastModifiedBy;

    @Column(name = "mf11_deactivatedOn")
    private LocalDateTime  deactivatedOn;

    @Column(name = "mf11_deactivatedBy")
    private String deactivatedBy;

    @Column(name = "mf11_reactivatedOn")
    private LocalDateTime  reactivatedOn;

    @Column(name = "mf11_reactivatedBy")
    private String reactivatedBy;

    @Transient
    private transient Boolean isActiveOldValue;




}
