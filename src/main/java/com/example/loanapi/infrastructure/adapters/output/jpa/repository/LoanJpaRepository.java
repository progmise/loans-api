package com.example.loanapi.infrastructure.adapters.output.jpa.repository;

import com.example.loanapi.infrastructure.adapters.output.jpa.entity.LoanEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanJpaRepository extends JpaRepository<LoanEntity, Long> {

	Page<LoanEntity> findAllByUserId(Long userId, Pageable pageable);
}
