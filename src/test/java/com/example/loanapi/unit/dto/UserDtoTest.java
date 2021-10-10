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

import com.example.loanapi.dto.UserDTO;
import com.example.loanapi.model.Loan;
import com.example.loanapi.model.User;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
public class UserDtoTest {

	@Autowired
	private ModelMapper modelMapper;		
	
    private UserDTO userDTO;
    private User user;
    private Loan loan;
    private Loan otherLoan;
    
    @Before
    public void setUp() {
    	
    	userDTO = new UserDTO();
    	user = new User();
    	loan = new Loan();
    	otherLoan = new Loan();

    	user.setId(new Long(1));
        user.setEmail("user@example.com");
        user.setFirstName("Leonel");
        user.setLastName("Chaves");
        
        loan.setTotal(4900.0);
        loan.setUser(user);
        
        otherLoan.setTotal(13100.10);
        otherLoan.setUser(user);
    }
    
    @Test
    public void shouldMapUserWithOneLoan() throws Exception {
        // Given
    	user.getLoans().add(loan);

        // When
        userDTO = modelMapper.map(user, UserDTO.class);

        // Then
        assertThat(user.getId()).isEqualTo(userDTO.getId());
        assertThat(user.getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(user.getFirstName()).isEqualTo(userDTO.getFirstName());
        assertThat(user.getLastName()).isEqualTo(userDTO.getLastName());
        assertThat(user.getLoans().get(0).getId()).isEqualTo(userDTO.getLoans().get(0).getId());
    }
    
    @Test
    public void shouldMapUserWithTwoLoans() throws Exception {
        // Given
    	user.getLoans().add(loan);
    	user.getLoans().add(otherLoan);

        // When
        userDTO = modelMapper.map(user, UserDTO.class);
        
        // Then
        assertThat(user.getId()).isEqualTo(userDTO.getId());
        assertThat(user.getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(user.getFirstName()).isEqualTo(userDTO.getFirstName());
        assertThat(user.getLastName()).isEqualTo(userDTO.getLastName());
        assertThat(user.getLoans().get(0).getId()).isEqualTo(userDTO.getLoans().get(0).getId());
        assertThat(user.getLoans().get(1).getId()).isEqualTo(userDTO.getLoans().get(1).getId());
    }
}
