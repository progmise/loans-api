package com.example.loanapi.utils.validator;

import java.util.ArrayList;
import java.util.List;

import com.example.loanapi.utils.exception.ExceptionCode;

import static com.example.loanapi.utils.ExceptionCodeUtil.generateRequiredFieldException;

public interface BaseValidator {

	LengthValidator lengthValidator = new LengthValidator();
	NumericValidator numericValidator = new NumericValidator();

	default void validateRequiredField(
			String value,
			String fieldName,
			List<String> fieldNames,
			List<ExceptionCode> exceptions) {

		if (value == null || value.trim().isEmpty()) {
			List<String> updatedFieldNames = new ArrayList<>(fieldNames);

			updatedFieldNames.add(fieldName);
			exceptions.add(generateRequiredFieldException(updatedFieldNames));
		}
	}
}
