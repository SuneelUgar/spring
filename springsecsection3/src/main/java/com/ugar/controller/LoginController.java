package com.ugar.controller;

import com.ugar.modal.Customer;
import com.ugar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping(value = "/register")
    public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer;
        ResponseEntity response = null;
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
