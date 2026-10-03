package com.example.loanapi.infrastructure.adapters.output.jpa;

import java.util.stream.Collectors;

import com.example.loanapi.application.ports.output.LoanDataOutputPort;
import com.example.loanapi.domain.model.Loan;
import com.example.loanapi.domain.model.Page;
import com.example.loanapi.infrastructure.adapters.output.jpa.entity.LoanEntity;
import com.example.loanapi.infrastructure.adapters.output.jpa.mapper.LoanEntityMapper;
import com.example.loanapi.infrastructure.adapters.output.jpa.repository.LoanJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class LoanJpaAdapter implements LoanDataOutputPort {

	private final LoanJpaRepository loanJpaRepository;

	@Autowired
	public LoanJpaAdapter(LoanJpaRepository loanJpaRepository) {
		this.loanJpaRepository = loanJpaRepository;
	}

	@Override
	public Page<Loan> findAll(Integer page, Integer size) {
		return toDomainPage(
				loanJpaRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending())));
	}

	@Override
	public Page<Loan> findAllByUserId(Long userId, Integer page, Integer size) {
		return toDomainPage(
				loanJpaRepository.findAllByUserId(
						userId, PageRequest.of(page, size, Sort.by("id").ascending())));
	}

	private static Page<Loan> toDomainPage(org.springframework.data.domain.Page<LoanEntity> entityPage) {
		return new Page<>(
				entityPage.getContent().stream()
						.map(LoanEntityMapper::toDomain)
						.collect(Collectors.toList()),
				entityPage.getNumber(),
				entityPage.getSize(),
				entityPage.getTotalElements());
	}
}
