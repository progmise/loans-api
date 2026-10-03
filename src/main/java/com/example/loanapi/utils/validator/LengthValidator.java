package com.example.loanapi.utils.validator;

import java.util.ArrayList;
import java.util.List;

import com.example.loanapi.utils.exception.ExceptionCode;
import com.example.loanapi.utils.tuple.Triple;

import static com.example.loanapi.utils.ExceptionCodeUtil.generateLengthException;

public class LengthValidator implements Validator<Triple<String, Integer, Integer>> {

	@Override
	public List<ExceptionCode> validate(Triple<String, Integer, Integer> data, List<String> fieldNames) {
		List<ExceptionCode> exceptions = new ArrayList<>();

		if (!isValid(data)) {
			exceptions.add(generateLengthException(fieldNames, data.getSecond(), data.getThird()));
		}

		return exceptions;
	}

	public static boolean isValid(Triple<String, Integer, Integer> data) {
		int length = data.getFirst().length();

		return length >= data.getSecond() && length <= data.getThird();
	}
}
