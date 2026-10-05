package io.github.progmise.loans.infrastructure.adapters.input.rest.dto.request.builder;

import java.util.ArrayList;
import java.util.List;

import io.github.progmise.commons.exception.BadRequestException;
import io.github.progmise.commons.exception.ExceptionCode;
import io.github.progmise.commons.util.Constants;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import io.github.progmise.loans.infrastructure.adapters.input.rest.validator.CreateUserRequestValidator;
import io.github.progmise.loans.infrastructure.adapters.input.rest.validator.UserIdValidator;

public class UserRequestBuilder {

	private final UserIdValidator userIdValidator;
	private final CreateUserRequestValidator createUserRequestValidator;

	public UserRequestBuilder(
			UserIdValidator userIdValidator,
			CreateUserRequestValidator createUserRequestValidator) {
		this.userIdValidator = userIdValidator;
		this.createUserRequestValidator = createUserRequestValidator;
	}

	public Long buildUserId(String userId) {
		List<ExceptionCode> exceptions = userIdValidator.validate(userId, new ArrayList<>());

		if (!exceptions.isEmpty()) {
			throw new BadRequestException(exceptions, Constants.ERROR_PATH);
		}

		return Long.valueOf(userId);
	}

	public CreateUserRequest build(CreateUserRequest request) {
		List<ExceptionCode> exceptions = createUserRequestValidator.validate(request, new ArrayList<>());

		if (!exceptions.isEmpty()) {
			throw new BadRequestException(exceptions, Constants.ERROR_BODY);
		}

		return request;
	}
}
