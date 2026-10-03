package com.example.loanapi.infrastructure.adapters.output.cache;

import java.util.concurrent.TimeUnit;

import com.example.loanapi.application.ports.output.UserCacheOutputPort;
import com.example.loanapi.domain.model.User;
import com.example.loanapi.infrastructure.config.cache.UserCacheProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserCacheRedisAdapter implements UserCacheOutputPort {

	private static final Logger LOG = LoggerFactory.getLogger(UserCacheRedisAdapter.class);
	private static final String KEY_SEPARATOR = "::";

	private final StringRedisTemplate redisTemplate;
	private final UserCacheProperties properties;
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	public UserCacheRedisAdapter(
			StringRedisTemplate redisTemplate,
			UserCacheProperties properties) {
		this.redisTemplate = redisTemplate;
		this.properties = properties;
	}

	@Override
	public User get(Long userId) {
		try {
			String json = redisTemplate.opsForValue().get(key(userId));

			return json != null ? objectMapper.readValue(json, User.class) : null;
		} catch (Exception ex) {
			LOG.warn("Could not read user {} from cache: {}", userId, ex.getMessage());

			return null;
		}
	}

	@Override
	public void put(Long userId, User user) {
		try {
			redisTemplate.opsForValue().set(
					key(userId),
					objectMapper.writeValueAsString(user),
					properties.getTimeToLive().getSeconds(),
					TimeUnit.SECONDS);
		} catch (Exception ex) {
			LOG.warn("Could not write user {} to cache: {}", userId, ex.getMessage());
		}
	}

	@Override
	public void evict(Long userId) {
		try {
			redisTemplate.delete(key(userId));
		} catch (Exception ex) {
			LOG.warn("Could not evict user {} from cache: {}", userId, ex.getMessage());
		}
	}

	private String key(Long userId) {
		return properties.getName() + KEY_SEPARATOR + userId;
	}
}
