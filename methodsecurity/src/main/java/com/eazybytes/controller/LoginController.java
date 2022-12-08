package com.eazybytes.controller;


import java.security.Principal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Principal user) {
		List<Customer> customers = customerRepository.findByEmail(user.getName());
		if (customers.size() > 0) {
			return customers.get(0);
		}else {
			return null;
		}
		
	}

	@PostMapping(value = "/register")
	public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
		Customer savedCustomer;
		ResponseEntity response = null;
		String hashPassword= passwordEncoder.encode(customer.getPwd());
		System.out.println("hashPassword" + hashPassword.length());
		customer.setPwd(hashPassword);
		customer.setCreateDt(new Date(System.currentTimeMillis()));
		try {
			savedCustomer = customerRepository.save(customer);
			if (savedCustomer.getId() > 0) {

				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Given user successfully registered");
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An Exception occured due to " + e.getMessage());
		}

		return response;

	}

}
