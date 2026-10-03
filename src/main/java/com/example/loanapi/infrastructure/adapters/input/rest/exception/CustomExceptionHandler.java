package com.example.loanapi.infrastructure.adapters.input.rest.exception;

import java.util.Collections;

import com.example.loanapi.domain.exception.ResourceNotFoundException;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.ApiError;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.ErrorsResponse;
import com.example.loanapi.utils.enums.ErrorLevel;
import com.example.loanapi.utils.exception.BadRequestException;
import com.example.loanapi.utils.exception.RequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	static final String INVALID_REQUEST_DESCRIPTION = "Invalid request";
	static final String INTERNAL_ERROR_DESCRIPTION = "Internal error";
	static final String NOT_FOUND_DESCRIPTION = "Not found";

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorsResponse> handleBadRequestException(BadRequestException ex) {
		return buildErrorResponse(
				ex,
				ex.getCode(),
				ex.getMessage(),
				resolveLevel(ex),
				INVALID_REQUEST_DESCRIPTION,
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorsResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return buildErrorResponse(
				ex,
				ex.getResourceName().toLowerCase() + ".not.found",
				ex.getMessage(),
				ErrorLevel.ERROR.getValue(),
				NOT_FOUND_DESCRIPTION,
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequestException.class)
	public ResponseEntity<ErrorsResponse> handleRequestException(RequestException ex) {
		return buildErrorResponse(
				ex,
				ex.getCode(),
				ex.getMessage(),
				resolveLevel(ex),
				ex.getDescription() != null ? ex.getDescription() : INVALID_REQUEST_DESCRIPTION,
				HttpStatus.valueOf(ex.getStatus()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorsResponse> handleUnknownException(Exception ex) {
		return buildErrorResponse(
				ex,
				HttpStatus.INTERNAL_SERVER_ERROR.name(),
				INTERNAL_ERROR_DESCRIPTION,
				ErrorLevel.ERROR.getValue(),
				ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private static ResponseEntity<ErrorsResponse> buildErrorResponse(
			Exception ex,
			String code,
			String message,
			String level,
			String description,
			HttpStatus status) {
		LOG.error("Exception: {} - Message: {}", ex.getClass().getSimpleName(), ex.getMessage(), ex);

		ApiError error = new ApiError(code, message, level, description);

		return new ResponseEntity<>(
				new ErrorsResponse(Collections.singletonList(error)), status);
	}

	private static String resolveLevel(RequestException ex) {
		return ex.getLevel() != null ? ex.getLevel().getValue() : ErrorLevel.ERROR.getValue();
	}
}
