package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.exceptions.CompanyException;
import com.example.exceptions.SupplierException;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public boolean createSupplier(String name, String address) throws SupplierException {
		Supplier supplier = new Supplier();
		if (name.isEmpty())
			throw new SupplierException("Supplier name is empty");
		supplier.setName(name);
		supplier.setAddress(address);
		supplierRepository.save(supplier);
		return false;
	}

	@Override
	public Supplier getSupplier(String id) throws SupplierException {
		Supplier supplier = supplierRepository.getOne(id);
		if (supplier == null)
			throw new SupplierException("No company exists with given id : " + id);
		return supplier;
	}

}
