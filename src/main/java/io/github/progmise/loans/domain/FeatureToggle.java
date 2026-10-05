package io.github.progmise.loans.domain;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum FeatureToggle implements Feature {

	@Label("Enable Redis cache lookups")
	LOANS_CACHE_ON;
}
