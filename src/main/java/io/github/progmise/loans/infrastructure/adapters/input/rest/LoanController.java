package io.github.progmise.loans.infrastructure.adapters.input.rest;

import io.github.progmise.loans.application.usecases.ListLoansUseCase;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.request.builder.LoanRequestBuilder;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.LoanResponse;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.PagedResponse;
import io.github.progmise.loans.infrastructure.adapters.input.rest.validator.PageableValidator;
import io.github.progmise.loans.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_VERSION + Constants.LOANS_PATH)
public class LoanController {

	private static final LoanRequestBuilder loanRequestBuilder =
			new LoanRequestBuilder(new PageableValidator());

	private final ListLoansUseCase listLoansUseCase;

	@Autowired
	public LoanController(ListLoansUseCase listLoansUseCase) {
		this.listLoansUseCase = listLoansUseCase;
	}

	@GetMapping
	public ResponseEntity<PagedResponse<LoanResponse>> listLoans(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "50") Integer size) {

		Integer[] validatedPageable = loanRequestBuilder.build(page - 1, size);

		PagedResponse<LoanResponse> response =
				listLoansUseCase.listLoans(validatedPageable[0], validatedPageable[1]);

		return ResponseEntity.ok(response);
	}

	@GetMapping(params = "user_id")
	public ResponseEntity<PagedResponse<LoanResponse>> listLoansByUserId(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "50") Integer size,
			@RequestParam(value = "user_id") Long userId) {

		Integer[] validatedPageable = loanRequestBuilder.build(page - 1, size);

		PagedResponse<LoanResponse> response =
				listLoansUseCase.listLoansByUserId(userId, validatedPageable[0], validatedPageable[1]);

		return ResponseEntity.ok(response);
	}
}
