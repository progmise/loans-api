package com.example.loanapi.application.ports.input;

import com.example.loanapi.application.ports.output.UserCacheOutputPort;
import com.example.loanapi.application.ports.output.UserDataOutputPort;
import com.example.loanapi.application.usecases.DeleteUserUseCase;
import com.example.loanapi.domain.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserInputPort implements DeleteUserUseCase {

	private static final Logger LOG = LoggerFactory.getLogger(DeleteUserInputPort.class);

	private final UserDataOutputPort userDataOutputPort;
	private final UserCacheOutputPort userCacheOutputPort;

	@Autowired
	public DeleteUserInputPort(
			UserDataOutputPort userDataOutputPort,
			UserCacheOutputPort userCacheOutputPort) {
		this.userDataOutputPort = userDataOutputPort;
		this.userCacheOutputPort = userCacheOutputPort;
	}

	@Override
	public void deleteUser(Long userId) {
		LOG.info("Deleting user with id: {}", userId);

		userDataOutputPort.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		userDataOutputPort.deleteById(userId);
		userCacheOutputPort.evict(userId);
	}
}
