package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BillingDetails;
import com.example.demo.model.Customer;
import com.example.demo.repository.BillingDetailsRepository;
import com.example.exceptions.BillingDetailsException;

@Service("billingDetailsService")
public class BillingDetailsServiceImpl implements BillingDetailsService {

	@Autowired
	private BillingDetailsRepository billingDetailsRepository;

	@Override
	public List<BillingDetails> getAll() {
		return billingDetailsRepository.findAll();
	}

	@Override
	public BillingDetails getById(String id) {
		return billingDetailsRepository.getOne(id);
	}

	@Override
	public boolean addABill(Customer customer, Date date) {
		BillingDetails bill = new BillingDetails();
		bill.setCustomer(customer);
		bill.setDate(date);
		billingDetailsRepository.save(bill);
		return true;
	}

	@Override
	public boolean updateBill(BillingDetails bill) throws BillingDetailsException {
		if (billingDetailsRepository.exists(bill.getId())) {
			billingDetailsRepository.save(bill);
			return true;
		} else
			throw new BillingDetailsException("Given billId doesn't exist " + bill);
	}

}
