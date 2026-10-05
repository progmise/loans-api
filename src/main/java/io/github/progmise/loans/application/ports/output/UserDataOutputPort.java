package io.github.progmise.loans.application.ports.output;

import java.util.Optional;

import io.github.progmise.loans.domain.model.User;

public interface UserDataOutputPort {

	Optional<User> findById(Long userId);

	User save(User user);

	void deleteById(Long userId);
}
