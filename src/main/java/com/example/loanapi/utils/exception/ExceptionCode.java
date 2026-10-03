package com.example.loanapi.utils.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class ExceptionCode {

	private final String code;
	private final String message;
}
