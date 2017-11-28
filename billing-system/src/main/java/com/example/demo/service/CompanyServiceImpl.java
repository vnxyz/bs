package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.exceptions.CompanyException;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	@Override
	public boolean createCompany(String name, String address) throws CompanyException {
		Company company = new Company();
		if(name.isEmpty())
			throw new CompanyException("company name is empty");
		company.setName(name);
		company.setAddress(address);
		companyRepository.save(company);
		return false;
	}

	@Override
	public Company getCompany(String id) throws CompanyException {
		Company company = companyRepository.getOne(id);
		if(company == null)
			throw new CompanyException("No company exists with given id : " + id);
		return company;
	}

}
