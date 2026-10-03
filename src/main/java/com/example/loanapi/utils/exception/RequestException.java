package com.example.loanapi.utils.exception;

import com.example.loanapi.utils.enums.ErrorLevel;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String code;
	private final String description;
	private final ErrorLevel level;
	private final Integer status;

	public RequestException(String code, String message, Integer status) {
		this(code, null, ErrorLevel.ERROR, message, status);
	}

	public RequestException(String code, String description, ErrorLevel level, String message, Integer status) {
		super(message);
		this.code = code;
		this.description = description;
		this.level = level;
		this.status = status;
	}
}
