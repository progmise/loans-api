package io.github.progmise.loans.infrastructure.adapters.output.jpa.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import io.github.progmise.loans.infrastructure.adapters.output.jpa.entity.UserEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class UserJpaRepositoryTest {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Test
	public void shouldFindUserById() {
		UserEntity user = new UserEntity();
		user.setEmail("find-test@example.com");
		user.setFirstName("Find");
		user.setLastName("Test");
		UserEntity saved = userJpaRepository.save(user);

		Optional<UserEntity> found = userJpaRepository.findById(saved.getId());

		assertThat(found).isPresent();
		assertThat(found.get().getEmail()).isEqualTo("find-test@example.com");
	}
}
