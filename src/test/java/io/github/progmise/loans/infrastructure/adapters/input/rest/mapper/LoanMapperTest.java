package io.github.progmise.loans.infrastructure.adapters.input.rest.mapper;

import org.junit.jupiter.api.Test;

import io.github.progmise.loans.domain.model.Loan;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.LoanResponse;

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
