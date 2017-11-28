package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Company;
import com.example.demo.model.Product;
import com.example.demo.model.ProductType;
import com.example.exceptions.ProductException;

public interface ProductService {
	public boolean createProduct(String name, ProductType type, Company company) throws ProductException;

	public Product getProductById(String id) throws ProductException;

	public List<Product> getProductsByName(String name) throws ProductException;

	public List<Product> getProductsByType(ProductType type) throws ProductException;

	public List<Product> getProductsByCompany(Company company) throws ProductException;
}
