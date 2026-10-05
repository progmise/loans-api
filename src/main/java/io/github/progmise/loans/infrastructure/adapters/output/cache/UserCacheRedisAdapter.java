package io.github.progmise.loans.infrastructure.adapters.output.cache;

import java.util.concurrent.TimeUnit;

import io.github.progmise.commons.infrastructure.FeatureToggleHelper;
import io.github.progmise.loans.application.ports.output.UserCacheOutputPort;
import io.github.progmise.loans.domain.FeatureToggle;
import io.github.progmise.loans.domain.model.User;
import io.github.progmise.loans.infrastructure.config.cache.UserCacheProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserCacheRedisAdapter implements UserCacheOutputPort {

	private static final Logger LOG = LoggerFactory.getLogger(UserCacheRedisAdapter.class);
	private static final String KEY_SEPARATOR = "::";

	private final StringRedisTemplate redisTemplate;
	private final UserCacheProperties properties;
	private final FeatureToggleHelper featureToggleHelper;
	private final ObjectMapper objectMapper = new ObjectMapper();

	public UserCacheRedisAdapter(
			StringRedisTemplate redisTemplate,
			UserCacheProperties properties,
			FeatureToggleHelper featureToggleHelper) {
		this.redisTemplate = redisTemplate;
		this.properties = properties;
		this.featureToggleHelper = featureToggleHelper;
	}

	@Override
	public User get(Long userId) {
		if (!featureToggleHelper.isActive(FeatureToggle.LOANS_CACHE_ON)) {
			return null;
		}

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
		if (!featureToggleHelper.isActive(FeatureToggle.LOANS_CACHE_ON)) {
			return;
		}

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
