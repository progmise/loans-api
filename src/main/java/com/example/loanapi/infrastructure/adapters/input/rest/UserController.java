package com.example.loanapi.infrastructure.adapters.input.rest;

import com.example.loanapi.application.usecases.CreateUserUseCase;
import com.example.loanapi.application.usecases.DeleteUserUseCase;
import com.example.loanapi.application.usecases.RetrieveUserUseCase;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.request.builder.UserRequestBuilder;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.ApiResponse;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.UserResponse;
import com.example.loanapi.infrastructure.adapters.input.rest.validator.CreateUserRequestValidator;
import com.example.loanapi.infrastructure.adapters.input.rest.validator.UserIdValidator;
import com.example.loanapi.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_VERSION + Constants.USERS_PATH)
public class UserController {

	private static final UserRequestBuilder userRequestBuilder =
			new UserRequestBuilder(new UserIdValidator(), new CreateUserRequestValidator());

	private final RetrieveUserUseCase retrieveUserUseCase;
	private final CreateUserUseCase createUserUseCase;
	private final DeleteUserUseCase deleteUserUseCase;

	@Autowired
	public UserController(
			RetrieveUserUseCase retrieveUserUseCase,
			CreateUserUseCase createUserUseCase,
			DeleteUserUseCase deleteUserUseCase) {
		this.retrieveUserUseCase = retrieveUserUseCase;
		this.createUserUseCase = createUserUseCase;
		this.deleteUserUseCase = deleteUserUseCase;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> retrieveUser(@PathVariable String userId) {
		Long validatedUserId = userRequestBuilder.buildUserId(userId);

		return ResponseEntity.ok(retrieveUserUseCase.retrieveUser(validatedUserId));
	}

	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
		CreateUserRequest validatedRequest = userRequestBuilder.build(request);

		return new ResponseEntity<>(
				createUserUseCase.createUser(validatedRequest), HttpStatus.CREATED);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
		Long validatedUserId = userRequestBuilder.buildUserId(userId);

		deleteUserUseCase.deleteUser(validatedUserId);

		return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "User deleted successfully"));
	}
}
