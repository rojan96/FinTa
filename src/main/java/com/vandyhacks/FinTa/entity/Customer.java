package com.vandyhacks.FinTa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private String balance;

	private String[] items;
}
