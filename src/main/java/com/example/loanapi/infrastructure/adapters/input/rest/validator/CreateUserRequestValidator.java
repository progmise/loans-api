package com.example.loanapi.infrastructure.adapters.input.rest.validator;

import java.util.ArrayList;
import java.util.List;

import com.example.loanapi.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import com.example.loanapi.utils.Constants;
import com.example.loanapi.utils.exception.ExceptionCode;
import com.example.loanapi.utils.tuple.Triple;
import com.example.loanapi.utils.validator.BaseValidator;
import com.example.loanapi.utils.validator.Validator;

public class CreateUserRequestValidator implements BaseValidator, Validator<CreateUserRequest> {

	public static final String EMAIL_FIELD_NAME = "email";
	public static final String FIRST_NAME_FIELD_NAME = "first_name";
	public static final String LAST_NAME_FIELD_NAME = "last_name";

	@Override
	public List<ExceptionCode> validate(CreateUserRequest data, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		validateRequiredField(data.getEmail(), EMAIL_FIELD_NAME, fieldNames, exceptions);
		validateRequiredField(data.getFirstName(), FIRST_NAME_FIELD_NAME, fieldNames, exceptions);
		validateRequiredField(data.getLastName(), LAST_NAME_FIELD_NAME, fieldNames, exceptions);

		exceptions.addAll(validateLength(data.getEmail(), EMAIL_FIELD_NAME, Constants.MAX_EMAIL_LENGTH, fieldNames));
		exceptions.addAll(validateLength(data.getFirstName(), FIRST_NAME_FIELD_NAME, Constants.MAX_FIRST_NAME_LENGTH, fieldNames));
		exceptions.addAll(validateLength(data.getLastName(), LAST_NAME_FIELD_NAME, Constants.MAX_LAST_NAME_LENGTH, fieldNames));

		return exceptions;
	}

	private List<ExceptionCode> validateLength(String value, String fieldName, int maxLength, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		if (value != null && !value.trim().isEmpty()) {
			List<String> updatedFieldNames = new ArrayList<>(fieldNames);

			updatedFieldNames.add(fieldName);

			exceptions.addAll(lengthValidator.validate(
					new Triple<>(value, 1, maxLength), updatedFieldNames));
		}

		return exceptions;
	}
}
