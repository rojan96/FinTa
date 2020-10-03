package com.vandyhacks.FinTa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vandyhacks.FinTa.entity.Customer;

@Service
public interface CustomerService {
	public Page<Customer> getAllCustomers(Pageable pageable);

	public String addCustomer(Customer customer);

	public Customer getCustomerbyUsername(String username);

	public Customer updateCurrentCustomer(Customer customer);

}
