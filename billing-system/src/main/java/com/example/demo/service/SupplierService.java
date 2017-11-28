package com.example.demo.service;

import com.example.demo.model.Supplier;
import com.example.exceptions.SupplierException;

public interface SupplierService {
	
	public boolean createSupplier(String name, String address) throws SupplierException;
	
	public Supplier getSupplier(String id) throws SupplierException;

}
