package com.example.loanapi.utils.validator;

import java.util.List;

import com.example.loanapi.utils.exception.ExceptionCode;

public interface Validator<T> {

	List<ExceptionCode> validate(T data, List<String> fieldNames);
}
