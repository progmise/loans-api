package com.example.loanapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loanapi.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
