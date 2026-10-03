package com.example.loanapi.infrastructure.adapters.input.rest.mapper;

import org.junit.Test;

import com.example.loanapi.domain.model.Loan;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.LoanResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanMapperTest {

	@Test
	public void shouldMapLoanToResponse() {
		Loan loan = new Loan(1L, 4900.0, 2L);

		LoanResponse response = LoanMapper.toLoanResponse(loan);

		assertThat(response.getId()).isEqualTo(loan.getId());
		assertThat(response.getTotal()).isEqualTo(loan.getTotal());
		assertThat(response.getUserId()).isEqualTo(loan.getUserId());
	}

	@Test
	public void shouldReturnNullForNullLoan() {
		assertThat(LoanMapper.toLoanResponse(null)).isNull();
	}
}
