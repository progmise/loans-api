package com.example.loanapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan({"com.example.loanapi.controller", "com.example.loanapi.service"})
public class LoanApiApplication {

	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}	
	
	public static void main(String[] args) {
		
		SpringApplication.run(LoanApiApplication.class, args);
	}

}
