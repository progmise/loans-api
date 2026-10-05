package io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private List<LoanResponse> loans = new ArrayList<>();
}
