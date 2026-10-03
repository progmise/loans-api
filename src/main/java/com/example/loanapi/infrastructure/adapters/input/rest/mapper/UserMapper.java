package com.example.loanapi.infrastructure.adapters.input.rest.mapper;

import java.util.stream.Collectors;

import com.example.loanapi.domain.model.User;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.UserResponse;

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
