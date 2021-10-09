package com.example.loanapi.unit.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.loanapi.model.User;
import com.example.loanapi.repository.UsersRepository;

@ActiveProfiles("test")
@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
public class UsersRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private UsersRepository usersRepository;
    
    private User user;
    private List<Long> usersIds;
    
    @Before
    public void setUp() {
    	
        user = new User();
        usersIds = new ArrayList<>();
        
        user.setEmail("user@example.com");
        user.setFirstName("Leonel");
        user.setLastName("Chaves");
    }
    
    @Test
    public void findAll() throws Exception {
        // Given
        entityManager.persist(user);
        entityManager.flush();

        // When
        List<User> usersList = usersRepository.findAll();

        // Then
        assertThat(usersList.size()).isEqualTo(1);
        assertThat(usersList.get(1)).isEqualTo(user);
    }
    
    @Test
    public void findAllById() throws Exception {
        // Given
        entityManager.persist(user);
        entityManager.flush();

        // When
        usersIds.add(user.getId());
        
        List<User> usersList = usersRepository.findAllById(usersIds);

        // Then
        assertThat(usersList.size()).isEqualTo(1);
        assertThat(usersList.get(1)).isEqualTo(user);
    }    
    
    @Test
    public void findById() throws Exception {
        // Given
        entityManager.persist(user);
        entityManager.flush();

        // When
        Optional<User> optional = usersRepository.findById(user.getId());
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
        usersRepository.deleteById(user.getId());
        List<User> usersList = usersRepository.findAll();

        // Then
        assertThat(usersList.size()).isEqualTo(1);
    }    
}
