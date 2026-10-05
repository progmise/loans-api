package io.github.progmise.loans.infrastructure.adapters.input.rest.mapper;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import io.github.progmise.loans.domain.model.Loan;
import io.github.progmise.loans.domain.model.User;
import io.github.progmise.loans.infrastructure.adapters.input.rest.dto.response.UserResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

	@Test
	public void shouldMapUserToResponse() {
		User user = new User();
		user.setId(2L);
		user.setEmail("user@example.com");
		user.setFirstName("Leonel");
		user.setLastName("Chaves");
		user.setLoans(Arrays.asList(new Loan(1L, 4900.0, 2L)));

		UserResponse response = UserMapper.toUserResponse(user);

		assertThat(response.getId()).isEqualTo(user.getId());
		assertThat(response.getEmail()).isEqualTo(user.getEmail());
		assertThat(response.getFirstName()).isEqualTo(user.getFirstName());
		assertThat(response.getLastName()).isEqualTo(user.getLastName());
		assertThat(response.getLoans()).hasSize(1);
		assertThat(response.getLoans().get(0).getUserId()).isEqualTo(2L);
	}

	@Test
	public void shouldReturnNullForNullUser() {
		assertThat(UserMapper.toUserResponse(null)).isNull();
	}
}
