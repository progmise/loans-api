package io.github.progmise.loans.application.usecases;

import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.LoanResponse;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.PagedResponse;

public interface ListLoansUseCase {

	PagedResponse<LoanResponse> listLoans(Integer page, Integer size);

	PagedResponse<LoanResponse> listLoansByUserId(Long userId, Integer page, Integer size);
}
