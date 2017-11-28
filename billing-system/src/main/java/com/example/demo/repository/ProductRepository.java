package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Company;
import com.example.demo.model.Product;
import com.example.demo.model.ProductType;

public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Query("from Product p where p.name=?1")
	public List<Product> getProductsByName(String name);
	@Query("from Product p where p.type=?1")
	public List<Product> getProductsByType(ProductType type);
	@Query("from Product p where p.company=?1")
	public List<Product> getProductsByCompany(Company company);
	
	
	
}
