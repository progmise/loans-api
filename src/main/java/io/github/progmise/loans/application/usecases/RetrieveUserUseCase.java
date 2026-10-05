package io.github.progmise.loans.application.usecases;

import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.UserResponse;

public interface RetrieveUserUseCase {

	UserResponse retrieveUser(Long userId);
}
