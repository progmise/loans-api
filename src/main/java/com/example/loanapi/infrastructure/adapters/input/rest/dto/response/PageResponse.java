package com.example.loanapi.infrastructure.adapters.input.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"page", "size", "total"})
public class PageResponse {

	private Long page;
	private Long size;
	private Long total;
}
