package com.example.loanapi.service;

import org.springframework.data.domain.Pageable;

import com.example.loanapi.dto.LoanDTO;
import com.example.loanapi.payload.PagedResponse;

public interface ILoanService {
	
    /**
     * Searches all the loans, according to the given number page
     * and with a maximum size of elements of pageable
     * Returns the found loans, in a paged response
     * @param pageable
     * @return
     */
    public PagedResponse<LoanDTO> getAllLoans(Pageable pageable);
    
    /**
     * Searches all the loans, according to the given number page with 
     * a maximum size of elements of pageable and filtered by a userId
     * Returns the found loans, in a paged response
     * @param pageable
     * @param userId
     * @return 
     */
    public PagedResponse<LoanDTO> getAllLoansByUserId(Pageable pageable, Long userId);    
}
