package com.example.loanapi.unit.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.loanapi.dao.UserDAO;
import com.example.loanapi.model.User;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private TestEntityManager entityManager;	
	
	@Autowired
	private UserDAO userDAO;
	
	private User user;
	
    @Before
    public void setUp() {
    	
        user = new User();
        
        user.setEmail("user@example.com");
        user.setFirstName("Leonel");
        user.setLastName("Chaves");
    }
    
    @Test
    public void save() throws Exception {
        // When
        User saved = userDAO.save(user);

        // Then
        assertThat(saved.getId()).isEqualTo(user.getId());
    }
    
    @Test
    public void findById() throws Exception {
        // Given
        entityManager.persist(user);
        entityManager.flush();

        // When
        Optional<User> optional = userDAO.findById(user.getId());
        User byId = optional.get();

        // Then
        assertThat(byId.getId()).isEqualTo(user.getId());
    }
    
    @Test
    public void deleteById() throws Exception {
    	// Given
    	entityManager.persist(user);
        entityManager.flush();

        // When
        userDAO.delete(user);
        Optional<User> optional = userDAO.findById(user.getId());

        // Then
        assertThat(optional.isPresent()).isFalse();
    }        
}
