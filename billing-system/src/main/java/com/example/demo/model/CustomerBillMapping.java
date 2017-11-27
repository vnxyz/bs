package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "CUSTOMER_BILL_MAPPING")
public class CustomerBillMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@NotNull
	@ManyToOne
	private Customer customer;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public int getBillId() {
		return id;
	}

	public void setBillId(int billId) {
		this.id = billId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
