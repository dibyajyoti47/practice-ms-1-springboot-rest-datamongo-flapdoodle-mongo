package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class HelloMongoController {
	
	@Autowired
	private CustomerRepository repo;
	
	@GetMapping(path="/")
	public ResponseEntity<String> sayHello() {		
		return new ResponseEntity<>("Hello Mongo.", HttpStatus.OK);
	}

}
