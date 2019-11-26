package com.siroi.assignment.mapper;

import com.siroi.assignment.domain.CompanyMaster;
import com.siroi.assignment.form.CompanyMasterForm;
import com.siroi.assignment.util.SiroiAssignmentHelper;
import org.apache.commons.lang3.StringUtils;

public class CompanyMasterMapper {

    private  CompanyMasterMapper() {

    }

    public static CompanyMaster toCompanyMaster(CompanyMasterForm form) {
            CompanyMaster companyMaster = new CompanyMaster();
            companyMaster.setCompanyName(form.getCompanyName());
            companyMaster.setCompanyAbbrName(form.getCompanyAbbrName());
            companyMaster.setCompanyLogo(form.getCompanyLogo());
            companyMaster.setCompCode(form.getCompCode());
            companyMaster.setCompCodeHRIS(form.getCompCodeHRIS());
            companyMaster.setCompRegNo(form.getCompRegNo());
            companyMaster.setIsActive(form.getIsActive());
            return companyMaster;
    }

    public static void updateCompanyMaster(CompanyMaster oldEntity, CompanyMaster updated) {

        oldEntity.setCompanyName(updated.getCompanyName());
        oldEntity.setCompanyAbbrName(updated.getCompanyAbbrName());
        oldEntity.setCompCode(updated.getCompCode());
        oldEntity.setCompCodeHRIS(updated.getCompCodeHRIS());
        oldEntity.setCompRegNo(updated.getCompRegNo());
        oldEntity.setIsActiveOldValue(oldEntity.getIsActive());
        oldEntity.setIsActive(updated.getIsActive());
        if(StringUtils.isNotEmpty(updated.getCompanyLogo())) {
            oldEntity.setCompanyLogo(updated.getCompanyLogo());
        }

    }

    public static CompanyMasterForm toCompanyMasterFrom(CompanyMaster companyMaster) {
        CompanyMasterForm form = new CompanyMasterForm();
        form.setCompanyName(companyMaster.getCompanyName());
        form.setCompanyAbbrName(companyMaster.getCompanyAbbrName());
        form.setCompanyLogo(companyMaster.getCompanyLogo());
        form.setCompCode(companyMaster.getCompCode());
        form.setCompCodeHRIS(companyMaster.getCompCodeHRIS());
        form.setCompRegNo(companyMaster.getCompRegNo());
        form.setIsActive(companyMaster.getIsActive());
        form.setActiveDate(SiroiAssignmentHelper.convertActiveDate(companyMaster.getActiveDate()));
        form.setCreatedBy(companyMaster.getCreatedBy());
        form.setLastModifiedBy(companyMaster.getLastModifiedBy());
        form.setReactivatedBy(companyMaster.getReactivatedBy());
        form.setDeactivatedBy(companyMaster.getDeactivatedBy());
        form.setCreatedOn(SiroiAssignmentHelper.convertLocalDateTime(companyMaster.getCreatedOn()));
        form.setLastModifiedOn(SiroiAssignmentHelper.convertLocalDateTime(companyMaster.getLastModifiedOn()));
        form.setDeactivatedOn(SiroiAssignmentHelper.convertLocalDateTime(companyMaster.getDeactivatedOn()));
        form.setReactivatedOn(SiroiAssignmentHelper.convertLocalDateTime(companyMaster.getReactivatedOn()));

        return form;
    }



}
