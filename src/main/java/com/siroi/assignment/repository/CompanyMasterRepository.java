package com.siroi.assignment.repository;

import com.siroi.assignment.domain.CompanyMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, String> {


    Page<CompanyMaster> findByCompanyNameContaining(String searchString, Pageable pageable);
}
