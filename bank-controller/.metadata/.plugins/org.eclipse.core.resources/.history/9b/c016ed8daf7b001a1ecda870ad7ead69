package com.springboot.platform;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.platform.daoimpl.BankDAOImpl;
import com.springboot.platform.persistence.Persistence;
import com.springboot.platform.serviceimpl.BankServiceImpl;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Bean
	public Persistence getPersistence() {
		return new Persistence();
	}

	@Bean
	public BankServiceImpl getBankServiceImpl() {
		return new BankServiceImpl();
	}

	@Bean
	public BankDAOImpl getBankDAOImpl() {
		return new BankDAOImpl();
	}

}
