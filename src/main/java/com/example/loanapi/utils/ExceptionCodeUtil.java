package com.example.loanapi.utils;

import java.text.MessageFormat;
import java.util.List;

import com.example.loanapi.utils.exception.ExceptionCode;

public final class ExceptionCodeUtil {

	private static final String REQUIRED_FIELD_CODE_TEMPLATE = "required.field.{0}";
	private static final String INVALID_VALUE_CODE_TEMPLATE = "invalid.value.{0}";
	private static final String INVALID_LENGTH_CODE_TEMPLATE = "invalid.length.{0}";
	private static final String REQUIRED_FIELD_MESSAGE_TEMPLATE = "The {0} is required";
	private static final String INVALID_NUMERIC_VALUE_MESSAGE_TEMPLATE = "The {0} provided must be numeric";
	private static final String INVALID_LENGTH_MESSAGE_TEMPLATE = "The {0} length is not between {1} and {2}";

	private ExceptionCodeUtil() {
	}

	public static ExceptionCode generateRequiredFieldException(List<String> fieldNames) {
		return new ExceptionCode(
				MessageFormat.format(REQUIRED_FIELD_CODE_TEMPLATE, String.join(".", fieldNames)),
				MessageFormat.format(REQUIRED_FIELD_MESSAGE_TEMPLATE, fieldNames.get(fieldNames.size() - 1)));
	}

	public static ExceptionCode generateNumericException(List<String> fieldNames) {
		return new ExceptionCode(
				MessageFormat.format(INVALID_VALUE_CODE_TEMPLATE, String.join(".", fieldNames)),
				MessageFormat.format(INVALID_NUMERIC_VALUE_MESSAGE_TEMPLATE, fieldNames.get(fieldNames.size() - 1)));
	}

	public static ExceptionCode generateLengthException(List<String> fieldNames, int min, int max) {
		return new ExceptionCode(
				MessageFormat.format(INVALID_LENGTH_CODE_TEMPLATE, String.join(".", fieldNames)),
				MessageFormat.format(INVALID_LENGTH_MESSAGE_TEMPLATE, fieldNames.get(fieldNames.size() - 1), min, max));
	}

	public static ExceptionCode generateInvalidValueException(List<String> fieldNames, String message) {
		return new ExceptionCode(
				MessageFormat.format(INVALID_VALUE_CODE_TEMPLATE, String.join(".", fieldNames)),
				message);
	}
}
