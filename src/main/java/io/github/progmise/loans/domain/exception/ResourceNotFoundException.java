package io.github.progmise.loans.domain.exception;

import io.github.progmise.commons.exception.RequestException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceNotFoundException extends RequestException {

	private static final long serialVersionUID = 5002389565249206069L;

	private final String resourceName;
	private final String fieldName;
	private final long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(
				HttpStatus.NOT_FOUND,
				resourceName.toLowerCase() + ".not.found",
				String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
