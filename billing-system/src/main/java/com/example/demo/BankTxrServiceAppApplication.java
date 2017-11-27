package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepostitory;
import com.example.demo.repository.TxnRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TxrService;

@SpringBootApplication
public class BankTxrServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTxrServiceAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(TxrService txrService, TxnRepository txnRepository, CustomerService custService,
			CustomerRepostitory customerRepository) {

		return args -> {

			txrService.txr(500.00, "1", "2");
			custService.createCustomer("Tom", "", "1234567890", "tom@cartoon.com");
			custService.createCustomer("Jerry", "", "1234567891", "jerry@cartoon.com");
			custService.createCustomer("Mickey", "Mouse", "1234567892", "mickey@disney.com");
			custService.createCustomer("Donald", "Duck", "1234567893", "donald@disney.com");
			// List<Txn> txns=txnRepository.listAll("1");
			// System.out.println(txns.size());
			System.out.println(customerRepository.getCustomerByEmailId("vd"));

		};

	}

}
