package com.vandyhacks.FinTa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vandyhacks.FinTa.entity.Customer;
import com.vandyhacks.FinTa.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/auth/customers")
	public Page<Customer> getAllCustomers(Pageable pageable) {
		return customerService.getAllCustomers(pageable);
	}

	@PostMapping("/customers")
	public String addUser(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

}