package com.example.loanapi.utils.tuple;

import java.util.List;

import lombok.Data;

import static java.util.Arrays.asList;

@Data
public final class Triple<A, B, C> {

	private final A first;
	private final B second;
	private final C third;

	public static <T> List<T> toList(Triple<T, T, T> triple) {
		return asList(triple.first, triple.second, triple.third);
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ")";
	}
}
