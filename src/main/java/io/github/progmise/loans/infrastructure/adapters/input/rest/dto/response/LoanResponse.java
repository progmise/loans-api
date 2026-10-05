package io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {

	private Long id;
	private Double total;
	private Long userId;
}
