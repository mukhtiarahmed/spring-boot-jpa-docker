/*
 * Copyright (C) 2017 Van Tibolli, All Rights Reserved.
 */
package com.siroi.assignment.service;


import com.siroi.assignment.domain.BaseEntity;
import com.siroi.assignment.exception.EntityNotFoundException;
import com.siroi.assignment.exception.InvalidDataException;
import com.siroi.assignment.exception.SiroiAssignmentException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The generic service. Served as a base interface for CRUD operations.
 *
 * @author  mukhtiar.ahmed
 * @version 1.0
 * @param <T> the generic entity type
 */
public interface GenericService<T extends BaseEntity, ID> {

    /**
     * This method is used to retrieve an entity.
     *
     * @param id the Id
     * @return the entity
     * @throws InvalidDataException if id is null
     * @throws EntityNotFoundException if the entity does not exist
     * @throws SiroiAssignmentException if any other error occurred during operation
     */
    T get(ID id) throws SiroiAssignmentException;

    /**
     * This method is used to create an entity.
     *
     * @param entity the entity
     * @return the created entity
     * @throws InvalidDataException if entity is null or not valid
     * @throws SiroiAssignmentException if any other error occurred during operation
     */
    T create(T entity) throws SiroiAssignmentException;

    /**
     * This method is used to update an entity.
     *
     * @param id the id
     * @param entity the entity
     * @return the updated entity
     * @throws InvalidDataException if entity is null or not valid.
     * @throws EntityNotFoundException if the entity does not exist
     * @throws SiroiAssignmentException if any other error occurred during operation
     */
    T update(ID id, T entity) throws SiroiAssignmentException;

    /**
     * This method is used to delete an entity.
     *
     * @param id the entity
     * @throws InvalidDataException if id is null
     * @throws EntityNotFoundException if the entity does not exist
     * @throws SiroiAssignmentException if any other error occurred during operation
     */
    void delete(ID id) throws SiroiAssignmentException;


    JpaRepository<T, ID> getRepository();

  
}
