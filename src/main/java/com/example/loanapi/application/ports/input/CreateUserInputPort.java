package com.example.loanapi.application.ports.input;

import com.example.loanapi.application.ports.output.UserDataOutputPort;
import com.example.loanapi.application.usecases.CreateUserUseCase;
import com.example.loanapi.domain.model.User;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.UserResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.loanapi.infrastructure.adapters.input.rest.mapper.UserMapper.toUserResponse;

@Component
public class CreateUserInputPort implements CreateUserUseCase {

	private static final Logger LOG = LoggerFactory.getLogger(CreateUserInputPort.class);

	private final UserDataOutputPort userDataOutputPort;

	@Autowired
	public CreateUserInputPort(UserDataOutputPort userDataOutputPort) {
		this.userDataOutputPort = userDataOutputPort;
	}

	@Override
	public UserResponse createUser(CreateUserRequest request) {
		LOG.info("Creating user with email: {}", request.getEmail());

		User user = new User();
		user.setEmail(request.getEmail());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());

		return toUserResponse(userDataOutputPort.save(user));
	}
}
