package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private MongoTemplate template;
	
	public void insertCustomer( Customer customer ) {
		repo.insert(customer);
	}

	public List<Customer> fetchAllCustomers() {
		return repo.findAll();
	}
	
	public Customer fetchCustomer(String id) {
		return repo.findById(id).orElseThrow();
	}
	
	public void deleteCustomerById(String cid) {
		repo.deleteById(cid);
	}
	
	public void updateCustomerById(String id, Customer customer) {
		repo.findById(id).orElseThrow();
		customer.setId(id);;
		template.save(customer);
	}
	
}
