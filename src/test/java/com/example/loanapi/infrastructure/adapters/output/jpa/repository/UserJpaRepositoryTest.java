package com.example.loanapi.infrastructure.adapters.output.jpa.repository;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.loanapi.infrastructure.adapters.output.jpa.entity.UserEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@RunWith(SpringRunner.class)
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
