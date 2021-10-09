package com.example.loanapi.service;

import com.example.loanapi.dto.UserDTO;

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
    public UserDTO createUser(UserDTO userDTO);
    
    
    /**
     * Deletes a user
     * @param user 
     */
    public void deleteUserById(Long id); 
}
