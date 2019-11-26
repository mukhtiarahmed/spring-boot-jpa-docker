/*
 * Copyright (C) 2017 Van Tibolli, All Rights Reserved.
 */
package com.siroi.assignment.service;

import com.siroi.assignment.annotations.LogMethod;
import com.siroi.assignment.domain.BaseEntity;
import com.siroi.assignment.dto.ListResponseDTO;
import com.siroi.assignment.dto.SearchCriteria;
import com.siroi.assignment.exception.SiroiAssignmentException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


/**
 * The base service exposing the list method.
 *
 * @author  mukhtiar.ahmed
 * @version 1.0
 * @param <T> the generic entity type
 */
public abstract class BaseListableService<T extends BaseEntity, ID> extends BaseService<T, ID>
        implements GenericListableService<T, ID> {

    /**
     * List all entities.
     *
     * @return the entity list
     * @throws SiroiAssignmentException if there is any error
     */
    @Override
    @LogMethod
    public List<T> list(){

        return repository.findAll();
    }

    @Override
    @LogMethod
    public ListResponseDTO<T> list(SearchCriteria searchCriteria) {
        ListResponseDTO responseDTO = new ListResponseDTO();

        Pageable pageable;
        if(StringUtils.isEmpty(searchCriteria.getSortColumn())) {
            pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getPageSize());
        } else {
            Sort  sort = Sort.by(new Sort.Order(Sort.Direction.fromString(searchCriteria.getSortOrder()),
                    searchCriteria.getSortColumn()));
            pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getPageSize(), sort);
        }
        Page<T> page =  repository.findAll(pageable);

        responseDTO.setData(page.getContent());
        responseDTO.setTotalElement(page.getTotalElements());
        return responseDTO;

    }



}
