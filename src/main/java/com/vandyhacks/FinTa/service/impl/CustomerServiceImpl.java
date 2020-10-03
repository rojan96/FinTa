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
		try {
			if (customerRepository.findByUsername(customer.getUsername()) != null)
				return "Username already exists";
		} catch (Exception e) {
			return "Username already exists";
		}
		String password = customer.getPassword();
		String encryptedPassword = passwordEncoder.encode(password);
		customer.setPassword(encryptedPassword);
		customerRepository.save(customer);
		return "Customer added successfully.";
	}

	@Override
	public Customer getCustomerbyUsername(String username) {
		return customerRepository.findByUsername(username);
	}

	public Customer updateCurrentCustomer(Customer dto) {
		Customer customer = customerRepository.findByUsername(dto.getUsername());
		customer.setEmail(dto.getEmail());
		customer.setFirstName(dto.getFirstName());
		customer.setItems(dto.getItems());
		customer.setLastName(dto.getLastName());
		customer.setBalance(dto.getBalance());
		customer.setUsername(dto.getUsername());

		return customerRepository.save(customer);
	}
}
