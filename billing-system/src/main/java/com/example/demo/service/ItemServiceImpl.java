package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.model.Product;
import com.example.demo.model.QuantityParameter;
import com.example.demo.model.Supplier;
import com.example.demo.repository.ItemRepository;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> getAll() {
		return itemRepository.findAll();
	}

	@Override
	public Item getById(String id) {
		return itemRepository.getOne(id);
	}

	@Override
	public boolean addItem(String name, Product product, int quantity, QuantityParameter quantityParameter, int price,
			Supplier supplier) {
		Item item = new Item();
		item.setName(name);
		item.setPrice(price);
		item.setProduct(product);
		item.setQuantity(quantity);
		item.setQuantityParameter(quantityParameter);
		item.setSupplier(supplier);
		itemRepository.save(item);
		return true;
	}



}
