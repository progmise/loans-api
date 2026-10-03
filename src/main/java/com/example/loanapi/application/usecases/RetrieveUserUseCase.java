package com.example.loanapi.application.usecases;

import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.UserResponse;

public interface RetrieveUserUseCase {

	UserResponse retrieveUser(Long userId);
}
