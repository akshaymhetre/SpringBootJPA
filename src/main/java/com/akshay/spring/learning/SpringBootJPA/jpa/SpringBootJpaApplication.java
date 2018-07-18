package com.akshay.spring.learning.SpringBootJPA.jpa;

import com.akshay.spring.learning.SpringBootJPA.jdbc.PersonJdbcDao;
import com.akshay.spring.learning.SpringBootJPA.jpa.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SpringBootJpaApplication.class);

	@Autowired
	EmployeeJpaRepository employeeJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Employee fetched: {}", employeeJpaRepository.findById(1));
		logger.info("All Employees : {}", employeeJpaRepository.findAll());
	}
}
