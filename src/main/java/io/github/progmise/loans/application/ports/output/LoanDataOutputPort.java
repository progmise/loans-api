package io.github.progmise.loans.application.ports.output;

import io.github.progmise.loans.domain.model.Loan;
import io.github.progmise.loans.domain.model.Page;

public interface LoanDataOutputPort {

	Page<Loan> findAll(Integer page, Integer size);

	Page<Loan> findAllByUserId(Long userId, Integer page, Integer size);
}
