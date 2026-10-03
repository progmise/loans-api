package com.example.loanapi.application.usecases;

import com.example.loanapi.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.UserResponse;

public interface CreateUserUseCase {

	UserResponse createUser(CreateUserRequest request);
}
