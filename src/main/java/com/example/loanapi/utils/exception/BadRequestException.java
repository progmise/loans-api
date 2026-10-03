package com.example.loanapi.utils.exception;

import com.example.loanapi.utils.enums.ErrorLevel;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class BadRequestException extends RequestException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String code, String message) {
		this(code, message, BAD_REQUEST.value());
	}

	public BadRequestException(String code, String message, Integer status) {
		super(code, message, status);
	}

	public BadRequestException(String code, String description, ErrorLevel level, String message) {
		super(code, description, level, message, BAD_REQUEST.value());
	}
}
