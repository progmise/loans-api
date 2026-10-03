package com.example.loanapi.infrastructure.adapters.input.rest.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.loanapi.utils.Constants;
import com.example.loanapi.utils.exception.ExceptionCode;
import com.example.loanapi.utils.validator.Validator;

import static com.example.loanapi.utils.ExceptionCodeUtil.generateInvalidValueException;

public class PageableValidator implements Validator<Integer[]> {

	public static final String PAGE_FIELD_NAME = "page";
	public static final String SIZE_FIELD_NAME = "size";

	@Override
	public List<ExceptionCode> validate(Integer[] data, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		Integer page = data[0];
		Integer size = data[1];

		if (page < Constants.DEFAULT_PAGE_NUMBER) {
			exceptions.add(generateInvalidValueException(
					Collections.singletonList(PAGE_FIELD_NAME),
					"Page number cannot be less than zero"));
		}

		if (size < Constants.DEFAULT_PAGE_SIZE) {
			exceptions.add(generateInvalidValueException(
					Collections.singletonList(SIZE_FIELD_NAME),
					"Size number cannot be less than " + Constants.DEFAULT_PAGE_SIZE));
		}

		if (size > Constants.MAX_PAGE_SIZE) {
			exceptions.add(generateInvalidValueException(
					Collections.singletonList(SIZE_FIELD_NAME),
					"Page size must not be greater than " + Constants.MAX_PAGE_SIZE));
		}

		return exceptions;
	}
}
