package com.example.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter  @ToString 
@Document (collection = "Customers")
public class Customer {
	
	@Id
	private String id;
	
	@Field("customer_name")
	private String customerName;
	
	@Field("customer_addresses")
	private List<Address> customerAdresses;
	
	@Field("customer_orders")
	private List<Order> customerOrders;
	
}
