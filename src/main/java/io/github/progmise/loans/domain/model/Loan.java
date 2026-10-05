package io.github.progmise.loans.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

	private Long id;
	private Double total;
	private Long userId;
}
