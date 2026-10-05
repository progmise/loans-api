package io.github.progmise.loans.infrastructure.adapters.input.rest.dto.request.builder;

import java.util.ArrayList;
import java.util.List;

import io.github.progmise.commons.exception.BadRequestException;
import io.github.progmise.commons.exception.ExceptionCode;
import io.github.progmise.commons.util.Constants;
import io.github.progmise.loans.infrastructure.adapters.input.rest.validator.PageableValidator;

public class LoanRequestBuilder {

	private final PageableValidator pageableValidator;

	public LoanRequestBuilder(PageableValidator pageableValidator) {
		this.pageableValidator = pageableValidator;
	}

	public Integer[] build(Integer page, Integer size) {
		List<ExceptionCode> exceptions = pageableValidator.validate(
				new Integer[] {page, size}, new ArrayList<>());

		if (!exceptions.isEmpty()) {
			throw new BadRequestException(exceptions, Constants.ERROR_PATH);
		}

		return new Integer[] {page, size};
	}
}
