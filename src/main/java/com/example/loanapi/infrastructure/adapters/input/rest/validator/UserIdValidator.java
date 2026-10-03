package com.example.loanapi.infrastructure.adapters.input.rest.validator;

import java.util.ArrayList;
import java.util.List;

import com.example.loanapi.utils.exception.ExceptionCode;
import com.example.loanapi.utils.validator.BaseValidator;
import com.example.loanapi.utils.validator.Validator;

public class UserIdValidator implements BaseValidator, Validator<String> {

	public static final String USER_ID_FIELD_NAME = "user_id";

	@Override
	public List<ExceptionCode> validate(String data, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		List<String> updatedFieldNames = new ArrayList<>(fieldNames);

		updatedFieldNames.add(USER_ID_FIELD_NAME);

		validateRequiredField(data, USER_ID_FIELD_NAME, fieldNames, exceptions);

		if (data != null && !data.trim().isEmpty()) {
			exceptions.addAll(numericValidator.validate(data, updatedFieldNames));
		}

		return exceptions;
	}
}
