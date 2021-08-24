package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloMongoController.class)
public class HelloMongoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void basicControllerTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals("Hello Mongo.", result.getResponse().getContentAsString());
	}
	
	@Test
	public void basicControllerTestType2() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(content().string("Hello Mongo."));
	}
	
}
