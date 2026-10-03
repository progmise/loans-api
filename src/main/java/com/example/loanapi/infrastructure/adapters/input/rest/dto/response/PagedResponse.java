package com.example.loanapi.infrastructure.adapters.input.rest.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<T> {

	private List<T> items;
	private PageResponse page;

	@JsonProperty("paging")
	public PageResponse getPage() {
		return page;
	}
}
