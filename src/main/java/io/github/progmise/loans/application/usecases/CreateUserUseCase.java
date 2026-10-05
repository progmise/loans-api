package io.github.progmise.loans.application.usecases;

import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.UserResponse;

public interface CreateUserUseCase {

	UserResponse createUser(CreateUserRequest request);
}
