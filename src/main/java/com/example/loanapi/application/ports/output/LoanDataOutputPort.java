package com.example.loanapi.application.ports.output;

import com.example.loanapi.domain.model.Loan;
import com.example.loanapi.domain.model.Page;

public interface LoanDataOutputPort {

	Page<Loan> findAll(Integer page, Integer size);

	Page<Loan> findAllByUserId(Long userId, Integer page, Integer size);
}
