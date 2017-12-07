package com.example.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Generated;

@XmlRootElement
@Entity
@Table(name = "ITEM_AND_UNITS")
public class ItemAndUnits {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@ManyToOne
	@NotNull
	private BillingDetails bill;
	@ManyToOne
	@NotNull
	private Item item;
	@NotNull
	private int noOfUnits;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BillingDetails getBill() {
		return bill;
	}
	public void setBill(BillingDetails bill) {
		this.bill = bill;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	@Override
	public String toString() {
		return "ItemAndUnits [id=" + id + ", bill=" + bill + ", item=" + item + ", noOfUnits=" + noOfUnits + "]";
	}


}
