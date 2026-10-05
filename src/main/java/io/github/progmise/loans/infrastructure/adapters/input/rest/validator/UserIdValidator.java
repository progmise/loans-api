package io.github.progmise.loans.infrastructure.adapters.input.rest.validator;

import io.github.progmise.commons.exception.ExceptionCode;
import io.github.progmise.commons.util.ExceptionCodeGenerators;
import io.github.progmise.commons.validator.NumericValidator;
import io.github.progmise.commons.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class UserIdValidator implements Validator<String> {

	public static final String USER_ID_FIELD_NAME = "user_id";

	private final NumericValidator numericValidator = new NumericValidator();

	@Override
	public List<ExceptionCode> validate(String data, List<String> fieldNames) {
		List<String> updatedFieldNames = new ArrayList<>(fieldNames);
		updatedFieldNames.add(USER_ID_FIELD_NAME);

		if (data == null || data.trim().isEmpty()) {
			return List.of(ExceptionCodeGenerators.generateRequiredFieldException(updatedFieldNames));
		}

		return numericValidator.validate(data, updatedFieldNames);
	}
}
