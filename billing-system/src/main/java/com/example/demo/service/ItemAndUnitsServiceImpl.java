package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BillingDetails;
import com.example.demo.model.Item;
import com.example.demo.model.ItemAndUnits;
import com.example.demo.repository.ItemAndUnitsRepository;
import com.example.exceptions.BillingDetailsException;

@Service("itemAndUnitsService")
public class ItemAndUnitsServiceImpl implements ItemAndUnitsService{

	@Autowired
	private ItemAndUnitsRepository itemAndUnitsRepository;
	@Autowired
	private BillingDetailsService billService;
	@Override
	public List<ItemAndUnits> getAll() {
		return itemAndUnitsRepository.findAll();
	}

	@Override
	public List<ItemAndUnits> getByBillId(String id) {
		return itemAndUnitsRepository.getByBillId(id);
	}

	@Override
	public boolean addItemToBill(ItemAndUnits itemAndUnits) {
		itemAndUnitsRepository.save(itemAndUnits);
		return true;
	}
	
	@Override
	public boolean addItemToBill(BillingDetails bill,Item item, int quantity) throws BillingDetailsException{
		ItemAndUnits itemAndUnits = new ItemAndUnits();
		bill.setAmount(bill.getAmount() + (item.getPrice()*quantity));
		billService.updateBill(bill);
		itemAndUnits.setBill(bill);
		itemAndUnits.setItem(item);
		itemAndUnits.setNoOfUnits(quantity);
		itemAndUnitsRepository.save(itemAndUnits);
		return true;
	}

}
