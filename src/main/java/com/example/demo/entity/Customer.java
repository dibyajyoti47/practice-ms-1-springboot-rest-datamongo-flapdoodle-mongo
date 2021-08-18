package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter  @ToString
@Document (collection = "Customers")
public class Customer {

}
