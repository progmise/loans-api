package io.github.progmise.loans.infrastructure.adapters.input.rest.validator;

import io.github.progmise.commons.exception.ExceptionCode;
import io.github.progmise.commons.util.ExceptionCodeGenerators;
import io.github.progmise.commons.validator.Validator;
import io.github.progmise.loans.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class PageableValidator implements Validator<Integer[]> {

	public static final String PAGE_FIELD_NAME = "page";
	public static final String SIZE_FIELD_NAME = "size";

	@Override
	public List<ExceptionCode> validate(Integer[] data, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		Integer page = data[0];
		Integer size = data[1];

		if (page < Constants.DEFAULT_PAGE_NUMBER) {
			exceptions.add(new ExceptionCode(
					"invalid.value." + PAGE_FIELD_NAME,
					"Page number cannot be less than zero"));
		}

		if (size < Constants.DEFAULT_PAGE_SIZE) {
			exceptions.add(ExceptionCodeGenerators.generateValueNotMajorOrEqualException(
					List.of(SIZE_FIELD_NAME), Constants.DEFAULT_PAGE_SIZE));
		}

		if (size > Constants.MAX_PAGE_SIZE) {
			exceptions.add(new ExceptionCode(
					"invalid.value." + SIZE_FIELD_NAME,
					"Page size must not be greater than " + Constants.MAX_PAGE_SIZE));
		}

		return exceptions;
	}
}
