package io.github.progmise.loans.infrastructure.adapters.output.jpa.mapper;

import java.util.stream.Collectors;

import io.github.progmise.loans.domain.model.User;
import io.github.progmise.loans.infrastructure.adapters.output.jpa.entity.UserEntity;

public final class UserEntityMapper {

	private UserEntityMapper() {
	}

	public static User toDomain(UserEntity entity) {
		if (entity == null) {
			return null;
		}

		User user = new User();

		user.setId(entity.getId());
		user.setEmail(entity.getEmail());
		user.setFirstName(entity.getFirstName());
		user.setLastName(entity.getLastName());
		user.setLoans(entity.getLoans() == null ? null : entity.getLoans().stream()
				.map(LoanEntityMapper::toDomain)
				.collect(Collectors.toList()));

		return user;
	}

	public static UserEntity toEntity(User user) {
		if (user == null) {
			return null;
		}

		UserEntity entity = new UserEntity();

		entity.setId(user.getId());
		entity.setEmail(user.getEmail());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());

		return entity;
	}
}
