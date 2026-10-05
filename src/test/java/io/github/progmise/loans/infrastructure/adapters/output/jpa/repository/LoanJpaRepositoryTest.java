package io.github.progmise.loans.infrastructure.adapters.output.jpa.repository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;


import io.github.progmise.loans.infrastructure.adapters.output.jpa.entity.LoanEntity;
import io.github.progmise.loans.infrastructure.adapters.output.jpa.entity.UserEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class LoanJpaRepositoryTest {

	@Autowired
	private LoanJpaRepository loanJpaRepository;

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Test
	public void shouldFindAllLoansByUserId() {
		UserEntity user = new UserEntity();
		user.setEmail("repo-test@example.com");
		user.setFirstName("Repo");
		user.setLastName("Test");
		user = userJpaRepository.save(user);

		LoanEntity loan = new LoanEntity();
		loan.setTotal(1000.0);
		loan.setUser(user);
		loanJpaRepository.save(loan);

		Page<LoanEntity> page =
				loanJpaRepository.findAllByUserId(user.getId(), PageRequest.of(0, 50));

		assertThat(page.getTotalElements()).isGreaterThanOrEqualTo(1);
		assertThat(page.getContent().get(0).getUser().getId()).isEqualTo(user.getId());
	}
}
