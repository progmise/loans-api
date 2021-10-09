package com.example.loanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.loanapi.dao")
public class LoanApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApiApplication.class, args);
	}

}
