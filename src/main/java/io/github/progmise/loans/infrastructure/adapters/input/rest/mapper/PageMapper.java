package io.github.progmise.loans.infrastructure.adapters.input.rest.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import io.github.progmise.loans.domain.model.Page;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.PageResponse;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.PagedResponse;

public final class PageMapper {

	private PageMapper() {
	}

	public static <T, R> PagedResponse<R> toPagedResponse(Page<T> page, Function<T, R> itemMapper) {
		PagedResponse<R> response = new PagedResponse<>();

		response.setItems(page.getContent().stream()
				.map(itemMapper)
				.collect(Collectors.toList()));
		response.setPage(new PageResponse(
				page.getPage() + 1,
				page.getSize(),
				page.getTotalElements()));

		return response;
	}
}
