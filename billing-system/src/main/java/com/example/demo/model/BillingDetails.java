package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "BILLING_DETAILS")
public class BillingDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private String id;
	@NotNull
	@ManyToOne
	private Customer customer;
	@NotNull
	private Date date;
	@NotNull
	private float billTotal = 0.0f;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public float getAmount() {
		return billTotal;
	}

	public void setAmount(float billTotal) {
		this.billTotal = billTotal;
	}

	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", customer=" + customer + ", date=" + date + ", billTotal=" + billTotal + "]";
	}
}
