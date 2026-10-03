package com.example.loanapi.infrastructure.config.cache;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "cache.users")
public class UserCacheProperties {

	private String name = "users";
	private TimeToLive timeToLive = new TimeToLive();

	@Data
	public static class TimeToLive {
		private long seconds = 300;
	}
}
