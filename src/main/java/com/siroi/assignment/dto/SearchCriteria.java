package com.siroi.assignment.dto;


import lombok.Data;

/**
 * Created by Ahmed on 8/16/2019.
 */
@Data
public class SearchCriteria {

    public static final String ASC = "ASC";

    public static final String DESC = "DESC";

    private String column;

    private String searchString;

    private int page;

    private int pageSize;

    private String sortColumn;

    private String sortOrder;

}
