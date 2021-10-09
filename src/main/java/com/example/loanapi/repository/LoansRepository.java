package com.example.loanapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loanapi.model.Loan;

public interface LoansRepository extends JpaRepository<Loan, Long> {

	Page<Loan> findAllByUser(Long userId, Pageable pageable);
}
