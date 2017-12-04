package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemBillMapping implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BillingDetails bill;
	@ManyToOne
	private Customer customer;
	public BillingDetails getBill() {
		return bill;
	}
	public void setBill(BillingDetails bill) {
		this.bill = bill;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "ItemBillMapping [bill=" + bill + ", customer=" + customer + "]";
	}
	
}
