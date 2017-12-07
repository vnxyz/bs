package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BillingDetails;
import com.example.demo.model.Item;
import com.example.demo.model.ItemAndUnits;
import com.example.exceptions.BillingDetailsException;

public interface ItemAndUnitsService {
	public List<ItemAndUnits> getAll();
	public List<ItemAndUnits> getByBillId(String id);
	public boolean addItemToBill(ItemAndUnits itemAndUnits);
	boolean addItemToBill(BillingDetails bill, Item item, int quantity) throws BillingDetailsException;
}
