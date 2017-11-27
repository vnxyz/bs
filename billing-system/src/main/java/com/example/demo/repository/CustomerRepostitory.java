package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Customer;

public interface CustomerRepostitory extends JpaRepository<Customer, String> {
	
	@Query("from Customer c where c.phoneNumber=?1")
	Customer getCustomerByPhoneNumber(String phoneNumber);
	
	@Query("from Customer c where c.emailId=?1")
	List<Customer> getCustomerByEmailId(String emailId);
	
}
