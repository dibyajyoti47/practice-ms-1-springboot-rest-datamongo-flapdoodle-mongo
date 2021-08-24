package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.controller.CustomerController;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;

@SpringBootTest
@ActiveProfiles("test")
class Microservice2ApplicationTests {
	
	@Autowired
	private CustomerController controller;
	
	@Test
	@Order(1)
	void contextLoads() {
		Customer customer = new Customer();	
		customer.setCustomerAdresses(getAddresses());
		customer.setCustomerOrders(getOrders());
		customer.setCustomerName("Linku");
		ResponseEntity<String> res = controller.insertCustomer(customer);
        System.out.println(res);
        assertEquals(res.getBody(), "Created.");
	}
	
	@Test
	@Order(2)
	void allCustomerstest() {
		ResponseEntity<List<Customer>> res = controller.allCustomers();
		assertNotNull(res);
	}
	
	private List<com.example.demo.entity.Order> getOrders() {
		com.example.demo.entity.Order order = new com.example.demo.entity.Order();
		order.setOrderDate(new Date());
		order.setOrderId("OD12345");
		order.setItems(getItems());
		ArrayList<com.example.demo.entity.Order> list = new ArrayList<com.example.demo.entity.Order>();
		list.add(order);
		return list;
	}

	private List<Item> getItems() {
		List<Item> list = new ArrayList<Item>();
		Item item = new Item();
		item.setItemName("testItemName");
		item.setSku("SKU12345");
		list.add(item);
		return list;
	}

	public List<Address> getAddresses () {
		Address a1 = new Address();
		a1.setPincode(123456);
		a1.setStreet("test street");		
		Address a2 = new Address();
		a2.setPincode(654321);
		a2.setStreet("street street");
		ArrayList<Address> list = new ArrayList<Address>();
		list.add(a1); list.add(a2);
		return list;
	}

}
