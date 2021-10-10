package com.example.loanapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.loanapi.constant.Paths;
import com.example.loanapi.dto.LoanDTO;
import com.example.loanapi.payload.PagedResponse;
import com.example.loanapi.service.LoanService;

@RestController
@RequestMapping(value=Paths.VERSION + Paths.LOANS)
public class LoanController {

    @Autowired
    private LoanService loanService;
    
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<PagedResponse<LoanDTO>> getAllLoans(
    		@PageableDefault(sort="id", direction=Direction.ASC) Pageable pageable) {
    	
    	PagedResponse<LoanDTO> pagedResponse = loanService.getAllLoans(pageable);
    	
    	return new ResponseEntity<PagedResponse<LoanDTO>>(pagedResponse, HttpStatus.OK);
    }     
}
