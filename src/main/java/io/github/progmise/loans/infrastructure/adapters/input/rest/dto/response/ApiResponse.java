package io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"success", "message"})
public class ApiResponse {

	private Boolean success;
	private String message;
}
