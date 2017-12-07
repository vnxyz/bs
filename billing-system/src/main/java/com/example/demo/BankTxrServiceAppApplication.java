package com.example.demo;

import java.util.Date;
import java.util.Iterator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.ItemAndUnits;
import com.example.demo.model.ProductType;
import com.example.demo.model.QuantityParameter;
import com.example.demo.repository.TxnRepository;
import com.example.demo.service.BillingDetailsService;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ItemAndUnitsService;
import com.example.demo.service.ItemService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SupplierService;
import com.example.demo.service.TxrService;

@SpringBootApplication
public class BankTxrServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTxrServiceAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(TxrService txrService, TxnRepository txnRepository, CustomerService custService,
			CompanyService companyService, SupplierService supplierService, ProductService productService,
			ItemService itemService, BillingDetailsService  billService, ItemAndUnitsService itemAndUnitsService) {

		return args -> {

			txrService.txr(500.00, "1", "2");
			// List<Txn> txns=txnRepository.listAll("1");
			// System.out.println(txns.size());
			/*
			 * Customer
			 */
			custService.createCustomer("Tom", "", "1234567890", "tom@cartoon.com");
			custService.createCustomer("Jerry", "", "1234567891", "jerry@cartoon.com");
			custService.createCustomer("Mickey", "Mouse", "1234567892", "mickey@disney.com");
			custService.createCustomer("Donald", "Duck", "1234567893", "donald@disney.com");
			
			/*
			 * Company
			 */
			companyService.createCompany("Disney", "USA");
			companyService.createCompany("Cartoon Network", "USA");
			companyService.createCompany("Hungama", "India");

			/*
			 * Supplier
			 */
			supplierService.createSupplier("Supplier1", "hyderabad");
			supplierService.createSupplier("Supplier2", "bangalore");

			productService.createProduct("TShirt MickeyMouse", ProductType.CLOTHES, companyService.getCompany("1"));
			productService.createProduct("TShirt DonaldDuck", ProductType.CLOTHES, companyService.getCompany("1"));
			productService.createProduct("TShirt Tom", ProductType.CLOTHES, companyService.getCompany("2"));
			productService.createProduct("MickeyMouse Biscuits", ProductType.PROCESSED_FOOD,
					companyService.getCompany("1"));
			productService.createProduct("DonaldDuck Biscuits", ProductType.PROCESSED_FOOD,
					companyService.getCompany("1"));
			
			itemService.addItem("TShirt MickeyMouse S", productService.getProductById("1"), 1,
					QuantityParameter.units, 500, supplierService.getSupplier("2"));
			itemService.addItem("TShirt MickeyMouse M", productService.getProductById("1"), 1,
					QuantityParameter.units, 500, supplierService.getSupplier("2"));
			itemService.addItem("TShirt MickeyMouse L", productService.getProductById("1"), 1,
					QuantityParameter.units, 500, supplierService.getSupplier("2"));
			itemService.addItem("TShirt MickeyMouse XL", productService.getProductById("1"), 1,
					QuantityParameter.units, 500, supplierService.getSupplier("2"));
			
			itemService.addItem("TShirt Tom Black S", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			itemService.addItem("TShirt Tom Black M", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			itemService.addItem("TShirt Tom Black L", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			itemService.addItem("TShirt Tom Black XL", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			itemService.addItem("TShirt Tom White S", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			itemService.addItem("TShirt Tom White M", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			itemService.addItem("TShirt Tom White L", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			itemService.addItem("TShirt Tom White XL", productService.getProductById("3"), 1,
					QuantityParameter.units, 450, supplierService.getSupplier("2"));
			
			itemService.addItem("MickeyMouse Biscuits small", productService.getProductById("4"), 250,
					QuantityParameter.grams, 50, supplierService.getSupplier("1"));
			itemService.addItem("MickeyMouse Biscuits large", productService.getProductById("4"), 500,
					QuantityParameter.grams, 75, supplierService.getSupplier("1"));
						
			billService.addABill(custService.getCustomerById("1"), new Date());
			billService.addABill(custService.getCustomerById("2"), new Date());
			billService.addABill(custService.getCustomerById("3"), new Date());
			
			itemAndUnitsService.addItemToBill(billService.getById("1"), itemService.getById("1"), 2);
			itemAndUnitsService.addItemToBill(billService.getById("1"), itemService.getById("5"), 2);
			itemAndUnitsService.addItemToBill(billService.getById("1"), itemService.getById("10"), 2);
			itemAndUnitsService.addItemToBill(billService.getById("1"), itemService.getById("14"), 10);
			
			System.out.println(custService.getCustomerByEmailId("tom@cartoon.com"));
			System.out.println(companyService.getCompany("1"));
			System.out.println(supplierService.getSupplier("1"));
			System.out.println(productService.getProductById("5"));
			System.out.println(itemService.getById("1"));
			System.out.println(billService.getById("1"));
			
			for (Iterator iterator = itemAndUnitsService.getAll().iterator(); iterator.hasNext();) {
				ItemAndUnits itemAndUnit = (ItemAndUnits) iterator.next();
				System.out.println(itemAndUnit);
				
			}
			
			
		};

	}

}
