package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepostitory;
import com.example.exceptions.CustomerException;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepostitory customerRepository;

	@Override
	public boolean createCustomer(String firstName, String lastName, String phoneNumber, String emailId)
			throws CustomerException {
		Customer customer = new Customer();
		if (firstName.isEmpty())
			throw new CustomerException("Please give first name");
		else
			customer.setFirstName(firstName);
		customer.setLastName(lastName);
		if (phoneNumber.isEmpty())
			throw new CustomerException("Please give phone number");
		else if (!phoneNumber.matches("\\d+"))
			throw new CustomerException("Invalid Phone Number");
		customer.setPhoneNumber(phoneNumber);
		customer.setEmailId(emailId);
		customerRepository.save(customer);
		return true;
	}

	@Override
	public Customer getCustomerByPhoneNumber(String phoneNumber) {
		return customerRepository.getCustomerByPhoneNumber(phoneNumber);
		
	}

	@Override
	public List<Customer> getCustomerByEmailId(String emailId) {
		return customerRepository.getCustomerByEmailId(emailId);
	}

}
