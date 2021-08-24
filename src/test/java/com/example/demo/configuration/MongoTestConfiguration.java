package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@Profile("test")
@EnableMongoRepositories(basePackages = "com.example.demo.repository")
public class MongoTestConfiguration {}

