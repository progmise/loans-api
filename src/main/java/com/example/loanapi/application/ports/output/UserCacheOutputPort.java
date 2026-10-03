package com.example.loanapi.application.ports.output;

import com.example.loanapi.domain.model.User;

public interface UserCacheOutputPort {

	User get(Long userId);

	void put(Long userId, User user);

	void evict(Long userId);
}
