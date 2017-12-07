package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.exceptions.CustomerException;

public interface CustomerService {
	public String createCustomer(String firstName, String lastName, String phoneNumber, String emailId) throws CustomerException;
	
	public Customer getCustomerByPhoneNumber(String phoneNumber);
	public List<Customer> getCustomerByEmailId(String emailId);
	public Customer getCustomerById(String id);
}
