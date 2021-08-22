package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping (path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertCustomer(@RequestBody Customer customer){
		service.insertCustomer(customer);
		return new ResponseEntity<>("Created.", HttpStatus.CREATED); 
	}
	
	@GetMapping (path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> allCustomers(){
		return new ResponseEntity<>(service.fetchAllCustomers(), HttpStatus.OK); 
	}
	
	@GetMapping (path = "/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> fetchCustomer (@PathVariable("cid") String id){
		return new ResponseEntity<>(service.fetchCustomer(id), HttpStatus.OK); 
	}
	
	@DeleteMapping (path= "/{cid}")
	public ResponseEntity<String> deleteCustomer (@PathVariable("cid") String id) {
		service.deleteCustomerById(id);
		return new ResponseEntity<> ("Deleted.", HttpStatus.OK);
	}
	
	@PutMapping (path = "/{cid}", produces = MediaType.APPLICATION_JSON_VALUE, 
								  consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCustomer (@PathVariable("cid") String id, @ RequestBody Customer customer){
		service.updateCustomerById(id, customer);
		return new ResponseEntity<>("updated.", HttpStatus.OK); 
	}
}
