package com.example.loanapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanapi.model.User;
import com.example.loanapi.repository.UserRepository;

@Service
public class UserDAO {
	@Autowired
	UserRepository userRepository;
	
    /**
     * Searches a user by id
     * Returns the found user, if it exists
     * @param id
     * @return 
     */
    public Optional<User> findById(Long id) {
    	
        return userRepository.findById(id);
    }
	
    /**
     * Saves a user
     * Returns the saved user
     * @param user
     * @return 
     */
    public User save(User user) {
    	
        return userRepository.save(user);
    }
    
    /**
     * Deletes a user
     * @param user 
     */
    public void delete(User user) {
    	
    	userRepository.delete(user);
    }
}
