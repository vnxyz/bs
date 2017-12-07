package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Item;
import com.example.demo.model.Product;
import com.example.demo.model.QuantityParameter;
import com.example.demo.model.Supplier;

public interface ItemService {
	public List<Item> getAll();
	public Item getById(String id);
	public boolean addItem(String name, Product product, int quantity, QuantityParameter quantityParameter, int price, Supplier supplier);
}
