/*
 * Copyright (C) 2017 Van Tibolli, All Rights Reserved.
 */
package com.siroi.assignment.service;

import com.siroi.assignment.domain.BaseEntity;
import com.siroi.assignment.dto.ListResponseDTO;
import com.siroi.assignment.dto.SearchCriteria;
import com.siroi.assignment.exception.SiroiAssignmentException;

import java.util.List;



/**
 * The generic service that expose the list method.
 *
 * @author mukhtiar.ahmed
 * @version 1.0
 * @param <T> the generic entity type
 */
public interface GenericListableService<T extends BaseEntity, ID> extends GenericService<T, ID>  {

	 /**
     * List all entities.
     *
     * @return the entity list
     * @throws SiroiAssignmentException if there is any error
     */
	  List<T> list() ;

	  ListResponseDTO<T> list(SearchCriteria searchCriteria) ;
}
