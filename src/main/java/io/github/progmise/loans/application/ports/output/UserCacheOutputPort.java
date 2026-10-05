package io.github.progmise.loans.application.ports.output;

import io.github.progmise.loans.domain.model.User;

public interface UserCacheOutputPort {

	User get(Long userId);

	void put(Long userId, User user);

	void evict(Long userId);
}
