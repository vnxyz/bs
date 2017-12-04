package com.example.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "ITEM_AND_UNITS")
public class ItemAndUnits {
	@EmbeddedId
	private ItemBillMapping itemBillMapping;
	@NotNull
	private int noOfUnits;
	public ItemBillMapping getItemBillMapping() {
		return itemBillMapping;
	}
	public void setItemBillMapping(ItemBillMapping itemBillMapping) {
		this.itemBillMapping = itemBillMapping;
	}
	public int getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	@Override
	public String toString() {
		return "ItemAndUnits [itemBillMapping=" + itemBillMapping + ", noOfUnits=" + noOfUnits + "]";
	}

}
