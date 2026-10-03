package com.example.loanapi.infrastructure.adapters.input.rest.dto.request.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.loanapi.infrastructure.adapters.input.rest.validator.PageableValidator;
import com.example.loanapi.utils.exception.BadRequestException;
import com.example.loanapi.utils.exception.ExceptionCode;

public class LoanRequestBuilder {

	private final PageableValidator pageableValidator;

	public LoanRequestBuilder(PageableValidator pageableValidator) {
		this.pageableValidator = pageableValidator;
	}

	public Integer[] build(Integer page, Integer size) {
		List<ExceptionCode> exceptions = pageableValidator.validate(
				new Integer[] {page, size}, new ArrayList<>());

		if (exceptions.isEmpty()) {
			return new Integer[] {page, size};
		}

		throw new BadRequestException(
				exceptions.get(0).getCode(),
				exceptions.get(0).getMessage());
	}
}
