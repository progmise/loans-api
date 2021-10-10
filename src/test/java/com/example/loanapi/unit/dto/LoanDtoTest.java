package com.example.loanapi.unit.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.loanapi.dto.LoanDTO;
import com.example.loanapi.model.Loan;
import com.example.loanapi.model.User;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
public class LoanDtoTest {

	@Autowired
	private ModelMapper modelMapper;		
	
    private LoanDTO loanDTO;
    private Loan loan;
    private User user;
    
    @Before
    public void setUp() {
    	
    	loanDTO = new LoanDTO();
    	loan = new Loan();
    	user = new User();

        loan.setId(new Long(1));
        loan.setTotal(4900.0);
    	
    	user.setId(new Long(2));
        user.setEmail("user@example.com");
        user.setFirstName("Leonel");
        user.setLastName("Chaves");
    }
    
    @Test
    public void shouldMapLoan() throws Exception {
        // Given
    	loan.setUser(user);

        // When
    	loanDTO = modelMapper.map(loan, LoanDTO.class);

        // Then
        assertThat(loan.getId()).isEqualTo(loanDTO.getId());
        assertThat(loan.getTotal()).isEqualTo(loanDTO.getTotal());
        assertThat(loan.getUser().getId()).isEqualTo(loanDTO.getUserId());
    }
}
