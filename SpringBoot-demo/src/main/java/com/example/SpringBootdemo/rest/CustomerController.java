package com.example.SpringBootdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.ws.RequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootdemo.model.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private List<Customer> customers;
	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@PostConstruct
	public void init() {
		log.info("Pre-construct worked!");
		customers = new ArrayList<>();
		customers.add(new Customer("John", "Doe", "john@email.com"));
		customers.add(new Customer("Kabir", "Singh", "kabir@example.com"));
		customers.add(new Customer("Lola", "Kutti", "lola@luv2code.com"));
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customers;
	}
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		customers.add(customer);
		return customer;
	}
	
	@PreDestroy
	public void destroy() {
		log.info("Post-Destroy worked!");
	}
}
