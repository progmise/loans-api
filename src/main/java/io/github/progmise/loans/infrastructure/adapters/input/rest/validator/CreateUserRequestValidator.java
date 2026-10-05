package io.github.progmise.loans.infrastructure.adapters.input.rest.validator;

import io.github.progmise.commons.exception.ExceptionCode;
import io.github.progmise.commons.util.ExceptionCodeGenerators;
import io.github.progmise.commons.validator.LengthValidator;
import io.github.progmise.commons.validator.Validator;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import io.github.progmise.loans.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class CreateUserRequestValidator implements Validator<CreateUserRequest> {

	public static final String EMAIL_FIELD_NAME = "email";
	public static final String FIRST_NAME_FIELD_NAME = "first_name";
	public static final String LAST_NAME_FIELD_NAME = "last_name";

	@Override
	public List<ExceptionCode> validate(CreateUserRequest data, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		exceptions.addAll(validateRequired(data.getEmail(), EMAIL_FIELD_NAME, Constants.MAX_EMAIL_LENGTH, fieldNames));
		exceptions.addAll(validateRequired(data.getFirstName(), FIRST_NAME_FIELD_NAME, Constants.MAX_FIRST_NAME_LENGTH, fieldNames));
		exceptions.addAll(validateRequired(data.getLastName(), LAST_NAME_FIELD_NAME, Constants.MAX_LAST_NAME_LENGTH, fieldNames));

		return exceptions;
	}

	private List<ExceptionCode> validateRequired(String value, String fieldName, int maxLength, List<String> fieldNames) {
		List<String> updatedFieldNames = new ArrayList<>(fieldNames);
		updatedFieldNames.add(fieldName);

		if (value == null || value.trim().isEmpty()) {
			return List.of(ExceptionCodeGenerators.generateRequiredFieldException(updatedFieldNames));
		}

		return new LengthValidator(1, maxLength).validate(value, updatedFieldNames);
	}
}
