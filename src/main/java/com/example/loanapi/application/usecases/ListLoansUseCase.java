package com.example.loanapi.application.usecases;

import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.LoanResponse;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.PagedResponse;

public interface ListLoansUseCase {

	PagedResponse<LoanResponse> listLoans(Integer page, Integer size);

	PagedResponse<LoanResponse> listLoansByUserId(Long userId, Integer page, Integer size);
}
