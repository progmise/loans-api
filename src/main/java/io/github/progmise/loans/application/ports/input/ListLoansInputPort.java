package io.github.progmise.loans.application.ports.input;

import io.github.progmise.loans.application.ports.output.LoanDataOutputPort;
import io.github.progmise.loans.application.usecases.ListLoansUseCase;
import io.github.progmise.loans.domain.model.Loan;
import io.github.progmise.loans.domain.model.Page;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.LoanResponse;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.PagedResponse;
import io.github.progmise.loans.infrastructure.adapters.input.rest.mapper.LoanMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.github.progmise.loans.infrastructure.adapters.input.rest.mapper.PageMapper.toPagedResponse;

@Component
public class ListLoansInputPort implements ListLoansUseCase {

	private static final Logger LOG = LoggerFactory.getLogger(ListLoansInputPort.class);

	private final LoanDataOutputPort loanDataOutputPort;

	@Autowired
	public ListLoansInputPort(LoanDataOutputPort loanDataOutputPort) {
		this.loanDataOutputPort = loanDataOutputPort;
	}

	@Override
	public PagedResponse<LoanResponse> listLoans(Integer page, Integer size) {
		LOG.info("Listing loans - page: {}, size: {}", page, size);

		Page<Loan> loans = loanDataOutputPort.findAll(page, size);

		return toPagedResponse(loans, LoanMapper::toLoanResponse);
	}

	@Override
	public PagedResponse<LoanResponse> listLoansByUserId(Long userId, Integer page, Integer size) {
		LOG.info("Listing loans for user id: {} - page: {}, size: {}", userId, page, size);

		Page<Loan> loans = loanDataOutputPort.findAllByUserId(userId, page, size);

		return toPagedResponse(loans, LoanMapper::toLoanResponse);
	}
}
