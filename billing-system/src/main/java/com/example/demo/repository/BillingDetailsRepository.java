package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.BillingDetails;

public interface BillingDetailsRepository extends JpaRepository<BillingDetails, String>{

}
