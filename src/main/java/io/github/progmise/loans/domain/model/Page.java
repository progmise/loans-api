package io.github.progmise.loans.domain.model;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Page<T> {

	private List<T> content;
	private long page;
	private long size;
	private long totalElements;

	public static <T> Page<T> empty() {
		return new Page<>(Collections.emptyList(), 0, 0, 0);
	}
}
