package io.github.progmise.loans.infrastructure.adapters.input.rest.mapper;

import java.util.stream.Collectors;

import io.github.progmise.loans.domain.model.User;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.UserResponse;

public final class UserMapper {

	private UserMapper() {
	}

	public static UserResponse toUserResponse(User user) {
		if (user == null) {
			return null;
		}

		UserResponse response = new UserResponse();

		response.setId(user.getId());
		response.setEmail(user.getEmail());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setLoans(user.getLoans() == null ? null : user.getLoans().stream()
				.map(LoanMapper::toLoanResponse)
				.collect(Collectors.toList()));

		return response;
	}
}
