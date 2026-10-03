package com.example.loanapi.application.ports.input;

import com.example.loanapi.application.ports.output.UserCacheOutputPort;
import com.example.loanapi.application.ports.output.UserDataOutputPort;
import com.example.loanapi.application.usecases.RetrieveUserUseCase;
import com.example.loanapi.domain.exception.ResourceNotFoundException;
import com.example.loanapi.domain.model.User;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.UserResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.loanapi.infrastructure.adapters.input.rest.mapper.UserMapper.toUserResponse;

@Component
public class RetrieveUserInputPort implements RetrieveUserUseCase {

	private static final Logger LOG = LoggerFactory.getLogger(RetrieveUserInputPort.class);

	private final UserDataOutputPort userDataOutputPort;
	private final UserCacheOutputPort userCacheOutputPort;

	@Autowired
	public RetrieveUserInputPort(
			UserDataOutputPort userDataOutputPort,
			UserCacheOutputPort userCacheOutputPort) {
		this.userDataOutputPort = userDataOutputPort;
		this.userCacheOutputPort = userCacheOutputPort;
	}

	@Override
	public UserResponse retrieveUser(Long userId) {
		LOG.info("Retrieving user information for id: {}", userId);

		User cachedUser = userCacheOutputPort.get(userId);

		if (cachedUser != null) {
			LOG.info("Returning cached user data for id: {}", userId);

			return toUserResponse(cachedUser);
		}

		User user = userDataOutputPort.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		userCacheOutputPort.put(userId, user);

		return toUserResponse(user);
	}
}
