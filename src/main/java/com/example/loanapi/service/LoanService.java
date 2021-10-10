package com.example.loanapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.loanapi.constant.AppConstants;
import com.example.loanapi.dto.LoanDTO;
import com.example.loanapi.dto.PageDTO;
import com.example.loanapi.exception.BadRequestException;
import com.example.loanapi.model.Loan;
import com.example.loanapi.payload.PagedResponse;
import com.example.loanapi.repository.LoansRepository;

@Service
public class LoanService implements ILoanService {

	@Autowired
	private ModelMapper modelMapper;	
	
	@Autowired
	private LoansRepository loansRepository;		
	
	@Override
	public PagedResponse<LoanDTO> getAllLoans(Pageable pageable) {
		
		validatePageNumberAndSize(pageable.getPageNumber(), pageable.getPageSize());
		
		Page<Loan> loans = loansRepository.findAll(pageable);
		
		PageDTO page = modelMapper.map(loans, PageDTO.class);
		
		List<LoanDTO> content = loans.getContent().stream()
				.map(loan -> modelMapper.map(loan, LoanDTO.class))
				.collect(Collectors.toList());
		
		return new PagedResponse<LoanDTO>(content, page);
	}
	
	@Override
	public PagedResponse<LoanDTO> getAllLoansByUserId(Pageable pageable, Long userId) {
		
		validatePageNumberAndSize(pageable.getPageNumber(), pageable.getPageSize());
		
		Page<Loan> loans = loansRepository.findAllByUserId(userId, pageable);
		
		PageDTO page = modelMapper.map(loans, PageDTO.class);
		
		List<LoanDTO> content = loans.getContent().stream()
				.map(loan -> modelMapper.map(loan, LoanDTO.class))
				.collect(Collectors.toList());
		
		return new PagedResponse<LoanDTO>(content, page);
	}
	
	private void validatePageNumberAndSize(Integer page, Integer size) {

		if (page < AppConstants.DEFAULT_PAGE_NUMBER) {

			throw new BadRequestException("Page number cannot be less than zero.");
		}

		if (size < AppConstants.DEFAULT_PAGE_SIZE) {

			throw new BadRequestException("Size number cannot be less than zero.");
		}

		if (size > AppConstants.MAX_PAGE_SIZE) {

			throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}
}
