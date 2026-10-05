package io.github.progmise.loans.infrastructure.adapters.output.jpa.repository;

import io.github.progmise.loans.infrastructure.adapters.output.jpa.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
