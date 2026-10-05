package io.github.progmise.loans.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private List<Loan> loans = new ArrayList<>();
}
