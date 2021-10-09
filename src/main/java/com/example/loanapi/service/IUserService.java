package com.example.loanapi.service;

import com.example.loanapi.dto.UserDTO;
import com.example.loanapi.model.User;

public interface IUserService {

    /**
     * Searches a user by id
     * Returns the found user, if it exists
     * @param id
     * @return 
     */
    public UserDTO getUserById(Long id);
    
    /**
     * Creates a user
     * Returns the created user
     * @param user
     * @return 
     */
    public UserDTO createUser(User user);
    
    
    /**
     * Deletes a user
     * @param user 
     */
    public void deleteUser(User user); 
}
