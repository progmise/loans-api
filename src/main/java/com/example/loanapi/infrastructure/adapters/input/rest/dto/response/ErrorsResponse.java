package com.example.loanapi.infrastructure.adapters.input.rest.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorsResponse {

	private List<ApiError> errors;
}
