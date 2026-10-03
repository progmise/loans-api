package com.example.loanapi.infrastructure.adapters.input.rest.dto.request.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.loanapi.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import com.example.loanapi.infrastructure.adapters.input.rest.validator.CreateUserRequestValidator;
import com.example.loanapi.infrastructure.adapters.input.rest.validator.UserIdValidator;
import com.example.loanapi.utils.exception.BadRequestException;
import com.example.loanapi.utils.exception.ExceptionCode;

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

		if (exceptions.isEmpty()) {
			return Long.valueOf(userId);
		}

		throw new BadRequestException(
				exceptions.get(0).getCode(),
				exceptions.get(0).getMessage());
	}

	public CreateUserRequest build(CreateUserRequest request) {
		List<ExceptionCode> exceptions = createUserRequestValidator.validate(request, new ArrayList<>());

		if (exceptions.isEmpty()) {
			return request;
		}

		throw new BadRequestException(
				exceptions.get(0).getCode(),
				exceptions.get(0).getMessage());
	}
}
