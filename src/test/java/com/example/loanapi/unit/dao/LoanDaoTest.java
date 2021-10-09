package com.example.loanapi.unit.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.loanapi.dao.LoanDAO;
import com.example.loanapi.model.Loan;
import com.example.loanapi.model.User;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
public class LoanDaoTest {

    @Autowired
    private TestEntityManager entityManager;	
    
    @Autowired
    private LoanDAO loanDAO;
    
    private Loan loan;
    private Loan otherLoan;
    private User user;
    private Pageable paging;    
    
    @Before
    public void setUp() {
    	
    	user = new User();
    	loan = new Loan();
    	otherLoan = new Loan();
    	paging = PageRequest.of(0, 50, Sort.by("id"));
    	
        user.setEmail("user@example.com");
        user.setFirstName("Leonel");
        user.setLastName("Chaves");
        
        entityManager.persist(user);
        entityManager.flush();
        
        loan.setTotal(4900.0);
        loan.setUser(user);
        
        otherLoan.setTotal(13100.10);
        otherLoan.setUser(user);
    }
    
    @Test
    public void findAll() throws Exception {
        // Given
        entityManager.persist(loan);
        entityManager.flush();

        // When
        List<Loan> loansList = loanDAO.findAll(paging).getContent();

        // Then
        assertThat(loansList.size()).isEqualTo(1);
        assertThat(loansList.get(0)).isEqualTo(loan);
    }
    
    @Test
    public void findAllByUser() throws Exception {
        // Given
        entityManager.persist(loan);
        entityManager.flush();
        
        entityManager.persist(otherLoan);
        entityManager.flush();        

        // When
        List<Loan> loansList = loanDAO.findAllByUserId(user.getId(), paging).getContent();
        
        // Then
        assertThat(loansList.size()).isEqualTo(2);
        assertThat(loansList.get(0)).isEqualTo(loan);
        assertThat(loansList.get(1)).isEqualTo(otherLoan);
    }    
}
