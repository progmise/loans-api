package com.example.loanapi.application.ports.output;

import java.util.Optional;

import com.example.loanapi.domain.model.User;

public interface UserDataOutputPort {

	Optional<User> findById(Long userId);

	User save(User user);

	void deleteById(Long userId);
}
