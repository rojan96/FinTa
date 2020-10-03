package com.vandyhacks.FinTa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vandyhacks.FinTa.entity.Customer;
import com.vandyhacks.FinTa.repository.CustomerRepository;
import com.vandyhacks.FinTa.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Page<Customer> getAllCustomers(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public String addCustomer(Customer customer) {
		String password = customer.getPassword();
		var encryptedPassword = passwordEncoder.encode(password);
		customer.setPassword(encryptedPassword);
		customerRepository.save(customer);
		return "customer added successfully.";
	}
}
