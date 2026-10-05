package io.github.progmise.loans.infrastructure.adapters.output.jpa;

import java.util.Optional;

import io.github.progmise.loans.application.ports.output.UserDataOutputPort;
import io.github.progmise.loans.domain.model.User;
import io.github.progmise.loans.infrastructure.adapters.output.jpa.mapper.UserEntityMapper;
import io.github.progmise.loans.infrastructure.adapters.output.jpa.repository.UserJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserJpaAdapter implements UserDataOutputPort {

	private final UserJpaRepository userJpaRepository;

	@Autowired
	public UserJpaAdapter(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public Optional<User> findById(Long userId) {
		return userJpaRepository.findById(userId)
				.map(UserEntityMapper::toDomain);
	}

	@Override
	public User save(User user) {
		return UserEntityMapper.toDomain(
				userJpaRepository.save(UserEntityMapper.toEntity(user)));
	}

	@Override
	public void deleteById(Long userId) {
		userJpaRepository.deleteById(userId);
	}
}
