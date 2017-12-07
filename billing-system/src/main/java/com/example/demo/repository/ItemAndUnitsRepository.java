package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ItemAndUnits;

public interface ItemAndUnitsRepository extends JpaRepository<ItemAndUnits, String>{
	
	@Query("from ItemAndUnits i where i.bill.id=?1")
	List<ItemAndUnits> getByBillId(String id);

}
