package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.exceptions.CompanyException;

public interface CompanyService {
	
	public boolean createCompany(String name, String address) throws CompanyException;
	
	public Company getCompany(String id) throws CompanyException;

}
