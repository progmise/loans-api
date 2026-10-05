package io.github.progmise.loans.infrastructure.adapters.output.jpa.mapper;

import io.github.progmise.loans.domain.model.Loan;
import io.github.progmise.loans.infrastructure.adapters.output.jpa.entity.LoanEntity;

public final class LoanEntityMapper {

	private LoanEntityMapper() {
	}

	public static Loan toDomain(LoanEntity entity) {
		if (entity == null) {
			return null;
		}

		Loan loan = new Loan();

		loan.setId(entity.getId());
		loan.setTotal(entity.getTotal());
		loan.setUserId(entity.getUser() != null ? entity.getUser().getId() : null);

		return loan;
	}
}
