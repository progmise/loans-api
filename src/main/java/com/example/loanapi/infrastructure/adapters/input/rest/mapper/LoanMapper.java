package com.example.loanapi.infrastructure.adapters.input.rest.mapper;

import com.example.loanapi.domain.model.Loan;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.LoanResponse;

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
