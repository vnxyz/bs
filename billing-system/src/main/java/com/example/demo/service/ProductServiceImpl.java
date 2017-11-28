package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.model.Product;
import com.example.demo.model.ProductType;
import com.example.demo.repository.ProductRepository;
import com.example.exceptions.ProductException;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public boolean createProduct(String name, ProductType type, Company company) throws ProductException {
		Product product = new Product();
		if (name.isEmpty())
			throw new ProductException("Product Name is Empty");
		else
			product.setName(name);
		if (type.toString().isEmpty())
			throw new ProductException("Product Type is not given");
		else
			product.setType(type);
		if (company.getId().isEmpty())
			throw new ProductException("Please specify valid Company for the product " + product.getName());
		else
			product.setCompany(company);
		productRepository.save(product);
		return true;
	}

	@Override
	public Product getProductById(String id) throws ProductException {
		Product product = productRepository.getOne(id);
		if(product.getId().isEmpty())
			throw new ProductException("Product doesn't exist for given id " + id);
		return product;
	}

	@Override
	public List<Product> getProductsByName(String name) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByType(ProductType type) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByCompany(Company company) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

}
