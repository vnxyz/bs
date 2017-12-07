package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.BillingDetails;
import com.example.demo.model.Customer;
import com.example.exceptions.BillingDetailsException;

public interface BillingDetailsService {
	public List<BillingDetails> getAll();
	public BillingDetails getById(String id);
	public boolean addABill(Customer customer, Date date);
	public boolean updateBill(BillingDetails bill) throws BillingDetailsException;
}
