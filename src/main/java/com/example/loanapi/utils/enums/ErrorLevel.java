package com.example.loanapi.utils.enums;

public enum ErrorLevel {

	ERROR("error"),
	WARNING("warning"),
	INFO("info");

	private final String value;

	ErrorLevel(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
