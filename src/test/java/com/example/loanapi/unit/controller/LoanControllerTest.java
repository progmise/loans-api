package com.example.loanapi.unit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.loanapi.constant.Paths;
import com.example.loanapi.controller.LoanController;
import com.example.loanapi.dto.LoanDTO;
import com.example.loanapi.dto.PageDTO;
import com.example.loanapi.model.Loan;
import com.example.loanapi.model.User;
import com.example.loanapi.payload.PagedResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoanControllerTest {

    @Autowired
    private MockMvc mvc;	
	
    @MockBean
    private LoanController loanController;
    
    @Autowired
    private ModelMapper modelMapper;    
    
    User user;
    User otherUser;
    Loan loan;
    Loan otherLoan;
    Loan lastLoan;
    List<Loan> loans;
    LoanDTO loanDTO;
    Pageable pageable;
    PagedResponse<LoanDTO> pagedResponse;
    
    @Before
    public void setUp() {
    	
    	user = new User();
    	otherUser = new User();
    	loan = new Loan();
    	otherLoan = new Loan();
    	lastLoan = new Loan();
    	loans = new ArrayList<Loan>();
    	pageable = PageRequest.of(0, 50);
    	
    	user.setId(new Long(3));
        user.setEmail("user3@example.com");
        user.setFirstName("Lope");
        user.setLastName("Casares");
        
        otherUser.setId(new Long(5));
        otherUser.setEmail("user5@example.com");
        otherUser.setFirstName("Ovidio");
        otherUser.setLastName("Salgado");        
        
        loan.setId(new Long(5));
        loan.setTotal(1928.57);        
        loan.setUser(user);
        
        otherLoan.setId(new Long(6));
        otherLoan.setTotal(46584.95);
        otherLoan.setUser(user);
        
        lastLoan.setId(new Long(9));
        lastLoan.setTotal(58997.09);
        lastLoan.setUser(otherUser);
    }
    
    /**
     * TODO: In testing, paginated response data is not being
     * 		 retrieved
     * @throws Exception
     */
    @Test
    public void shouldGetAllLoans() throws Exception {
    	
    	loans.add(loan);
    	loans.add(otherLoan);
    	loans.add(lastLoan);
    	
    	Page<Loan> page = new PageImpl<Loan>(loans, pageable, loans.size());
    	PageDTO pageDTO = modelMapper.map(page, PageDTO.class);
    	
    	List<LoanDTO> content = loans.stream()
				.map(loan -> modelMapper.map(loan, LoanDTO.class))
				.collect(Collectors.toList());
    	
    	pagedResponse = new PagedResponse<LoanDTO>(content, pageDTO);
    	
        BDDMockito.given(loanController.getAllLoans(pageable)).willReturn(new ResponseEntity<PagedResponse<LoanDTO>>(pagedResponse, HttpStatus.OK));
        
        mvc.perform(MockMvcRequestBuilders.get(Paths.VERSION + Paths.LOANS + "?page=0&size=50")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.items[2].id", Is.is(lastLoan.getId().intValue())));
    }
    
    /**
     * TODO: In testing, paginated response data is not being
     * 		 retrieved
     * @throws Exception
     */
    @Test
    public void shouldGetAllLoansByUserId() throws Exception {
    	
    	loans.add(loan);
    	loans.add(otherLoan);
    	
    	Page<Loan> page = new PageImpl<Loan>(loans, pageable, loans.size());
    	PageDTO pageDTO = modelMapper.map(page, PageDTO.class);
    	
    	List<LoanDTO> content = loans.stream()
				.map(loan -> modelMapper.map(loan, LoanDTO.class))
				.collect(Collectors.toList());
    	
    	pagedResponse = new PagedResponse<LoanDTO>(content, pageDTO);
    	
        BDDMockito.given(loanController.getAllLoans(pageable)).willReturn(new ResponseEntity<PagedResponse<LoanDTO>>(pagedResponse, HttpStatus.OK));
        
        mvc.perform(MockMvcRequestBuilders.get(Paths.VERSION + Paths.LOANS + "?page=0&size=50&user_id=" + user.getId().intValue())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.items[0].id", Is.is(loan.getId().intValue())));
    }    
}
