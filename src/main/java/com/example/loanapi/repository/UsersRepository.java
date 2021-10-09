package com.example.loanapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loanapi.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	
}
