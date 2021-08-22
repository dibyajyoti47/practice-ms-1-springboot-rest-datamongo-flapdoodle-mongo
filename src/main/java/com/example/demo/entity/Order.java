package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Order {
	
	private List<Item> items;
	private String orderId;
	
	private Date orderDate;
	
}
