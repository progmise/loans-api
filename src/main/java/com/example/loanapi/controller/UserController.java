package com.example.loanapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.loanapi.constant.Paths;
import com.example.loanapi.dto.UserDTO;
import com.example.loanapi.payload.ApiResponse;
import com.example.loanapi.service.UserService;

@RestController
@RequestMapping(value=Paths.VERSION + Paths.USERS)
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value="id") Long id) {
    	
    	UserDTO userResponse = userService.getUserById(id);
    	
    	return new ResponseEntity<UserDTO>(userResponse, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
    	
		UserDTO userResponse = userService.createUser(userDTO);
    	
    	return new ResponseEntity<UserDTO>(userResponse, HttpStatus.CREATED);
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable(value="id") Long id) {
    	
		userService.deleteUserById(id);
		ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "User deleted successfully", HttpStatus.OK);
		
    	return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }    
}
