package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;



@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@MockBean
	private CustomerService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void insertCustomerTest() {
		
	}
	
	@Test
	public void fetchCustomerTest() throws Exception {
		Customer c = new Customer();
		c.setId("123"); c.setCustomerName("Linku");
		when(service.fetchCustomer(anyString())).thenReturn(c);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers/123");
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andExpect(content().json("{id:123, customerName: Linku }"));
	}
}
