/*
 * Copyright (C) 2017 Van Tibolli, All Rights Reserved.
 */
package com.siroi.assignment.service;


import com.siroi.assignment.annotations.LogMethod;
import com.siroi.assignment.domain.BaseEntity;
import com.siroi.assignment.exception.ConfigurationException;
import com.siroi.assignment.exception.EntityNotFoundException;
import com.siroi.assignment.exception.InvalidDataException;
import com.siroi.assignment.util.SiroiAssignmentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

import static com.siroi.assignment.util.SiroiAssignmentHelper.checkConfigNotNull;


/**
 * This is a base class for services that provides basic CRUD capabilities.
 *
 * @author  mukhtiar.ahmed
 * @version 1.0
 * @param <T> the generic entity type
 */

public abstract class BaseService<T extends BaseEntity, ID> implements GenericService<T, ID> {

    /**
     * The repository.
     */
    @Autowired 
    protected JpaRepository<T, ID> repository;

   
    /**
     * Check the configuration.
     *
     * @throws ConfigurationException if there's any error in configuration
     */
    @PostConstruct
    public void checkConfiguration() {
        checkConfigNotNull(repository, "repository");
    }

    /**
     * This method is used to retrieve an entity.
     *
     * @param id the Id
     * @return the entity
     * @throws InvalidDataException if id is null
     * @throws EntityNotFoundException if the entity does not exist
     */
    @Override
    @LogMethod
    public T get(ID id) {
    	SiroiAssignmentHelper.checkNull(id, "id");
        Optional<T> optional = repository.findById(id);
        T entity = optional.get();
        SiroiAssignmentHelper.checkEntityExist(entity, id);
        return entity;
    }

    /**
     * This method is used to create an entity.
     *
     * @param entity the entity
     * @return the created entity
     * @throws InvalidDataException if entity is null or not valid
     */
    @Override
    @LogMethod
    public T create(T entity) {
        SiroiAssignmentHelper.checkNull(entity, "entity");
        return repository.save(entity);
    }

    /**
     * This method is used to delete an entity.
     *
     * @param id the entity
     * @throws InvalidDataException if id is null;
     */
    @Override
    @LogMethod
    public void delete(ID id) {
        SiroiAssignmentHelper.checkNull(id, "id");
        repository.deleteById(id);
    }
    
    public JpaRepository<T, ID> getRepository() {
		return repository;
	}

}
