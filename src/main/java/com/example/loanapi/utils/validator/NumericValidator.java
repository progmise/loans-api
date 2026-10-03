package com.example.loanapi.utils.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.example.loanapi.utils.exception.ExceptionCode;

import static com.example.loanapi.utils.ExceptionCodeUtil.generateNumericException;

public class NumericValidator implements Validator<String> {

	private static final Pattern NUMERIC_PATTERN = Pattern.compile("^\\d+$");

	@Override
	public List<ExceptionCode> validate(String data, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		if (!isValid(data)) {
			exceptions.add(generateNumericException(fieldNames));
		}

		return exceptions;
	}

	public static boolean isValid(String data) {
		return NUMERIC_PATTERN.matcher(data).matches();
	}
}
