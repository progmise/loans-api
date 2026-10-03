package com.example.loanapi.infrastructure.adapters.input.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

	private String email;
	private String firstName;
	private String lastName;
}
