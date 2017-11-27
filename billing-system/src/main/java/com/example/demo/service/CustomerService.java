package com.example.demo.service;

import com.example.exceptions.CustomerException;

public interface CustomerService {
	public boolean createCustomer(String firstName, String lastName, String phoneNumber, String emailId) throws CustomerException;
}
