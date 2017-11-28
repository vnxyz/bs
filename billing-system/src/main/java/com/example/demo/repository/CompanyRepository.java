package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {
	
	@Query("from Company c where c.id=?1")
	public Company getCompanyDetails(String id);

}
