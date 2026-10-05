package io.github.progmise.loans.infrastructure.adapters.input.rest.mapper;

import io.github.progmise.loans.domain.model.Loan;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.LoanResponse;

public final class LoanMapper {

	private LoanMapper() {
	}

	public static LoanResponse toLoanResponse(Loan loan) {
		if (loan == null) {
			return null;
		}

		return new LoanResponse(loan.getId(), loan.getTotal(), loan.getUserId());
	}
}
