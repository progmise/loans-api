package com.example.loanapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.loanapi.model.Loan;
import com.example.loanapi.repository.LoansRepository;

@Service
public class LoanDAO {
	@Autowired
	LoansRepository loanRepository;
	
    /**
     * Lists all the loans by a pageable
     * Returns all the loans in a page
     * @param pageable
     * @return 
     */
    public Page<Loan> findAll(Pageable pageable) {
    	
        return loanRepository.findAll(pageable);
    }	
    
    /**
     * Lists all the loans by a pageable and a userId
     * Returns all the loans in a page
     * @param userId, pageable
     * @return 
     */
    public Page<Loan> findAllByUserId(Long userId, Pageable pageable) {
    	
        return loanRepository.findAllByUserId(userId, pageable);
    }    
}
