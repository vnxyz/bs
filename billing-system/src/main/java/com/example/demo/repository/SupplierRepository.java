package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Company;
import com.example.demo.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {

}
