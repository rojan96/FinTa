package com.vandyhacks.FinTa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vandyhacks.FinTa.entity.Customer;
import com.vandyhacks.FinTa.repository.CustomerRepository;

@Service
public class CustomCustomerDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUsername(username);
		CustomCustomerDetails customerDetails = null;
		if (customer != null) {
			customerDetails = new CustomCustomerDetails();
			customerDetails.setCustomer(customer);
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return customerDetails;
	}

}
