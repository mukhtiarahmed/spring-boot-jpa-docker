package com.siroi.assignment.service;


import com.siroi.assignment.annotations.LogMethod;
import com.siroi.assignment.domain.CompanyMaster;
import com.siroi.assignment.dto.ListResponseDTO;
import com.siroi.assignment.dto.SearchCriteria;
import com.siroi.assignment.exception.SiroiAssignmentException;
import com.siroi.assignment.mapper.CompanyMasterMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.siroi.assignment.util.SiroiAssignmentHelper.checkNull;
/**
 * The Company service
 *
 * @author  mukhtiar.ahmed
 * @version 1.0
 */

@Slf4j
@Service
public class CompanyServiceImpl extends BaseListableService<CompanyMaster, String> implements CompanyService   {

    private final List<String> columnCompMaster = Arrays.asList(
                        "compCode", "companyName", "lastModifiedBy", "lastModifiedOn");

    @Value("${page.size:10}")
    private int pageSize;


    @Override
    public CompanyMaster update(String compCode, CompanyMaster entity) throws SiroiAssignmentException {
        checkNull(compCode, "compCode");
        checkNull(entity, "entity");
        CompanyMaster oldEntity = get(compCode);
        oldEntity.setIsActiveOldValue(oldEntity.getIsActive());
        CompanyMasterMapper.updateCompanyMaster(oldEntity, entity);
        return repository.save(oldEntity);
    }


    @Override
    @LogMethod
    public ListResponseDTO<CompanyMaster> list(SearchCriteria searchCriteria) {
        searchCriteria.setPageSize(pageSize);
        if(StringUtils.isEmpty(searchCriteria.getSortColumn()) ||
                !columnCompMaster.contains(searchCriteria.getSortColumn())) {
            searchCriteria.setSortColumn("");
        }
        if(StringUtils.isEmpty(searchCriteria.getSearchString()) ||
                !columnCompMaster.contains(searchCriteria.getColumn()))  {
            return super.list(searchCriteria);
        }


        Pageable pageable;
        if(StringUtils.isEmpty(searchCriteria.getSortColumn())) {
            pageable = PageRequest.of(searchCriteria.getPage(), searchCriteria.getPageSize());
        } else {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.fromString(searchCriteria.getSortOrder()),
                    searchCriteria.getSortColumn()));
            pageable = PageRequest.of(searchCriteria.getPage(), pageSize, sort);
        }


        CompanyMaster companyMaster = new CompanyMaster();
        switch (searchCriteria.getColumn()) {
            case  "compCode" : companyMaster.setCompCode(searchCriteria.getSearchString()); break;
            case  "companyName" : companyMaster.setCompanyName(searchCriteria.getSearchString()); break;
            case  "lastModifiedBy" : companyMaster.setLastModifiedBy(searchCriteria.getSearchString()); break;
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase(searchCriteria.getColumn())
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<CompanyMaster> example  = Example.of(companyMaster, matcher);
        Page<CompanyMaster> page =  repository.findAll(example, pageable);

        ListResponseDTO responseDTO = new ListResponseDTO();

        responseDTO.setData(page.getContent());
        responseDTO.setTotalElement(page.getTotalElements());
        return responseDTO;

    }
}
