package com.example.loanapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.loanapi.constant.Paths;
import com.example.loanapi.dto.UserDTO;
import com.example.loanapi.service.UserService;

@RestController
@RequestMapping(value=Paths.VERSION + Paths.USERS)
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value="id") Long id) {
    	
    	UserDTO userDTO = userService.getUserById(id);
    	
    	return ResponseEntity.ok().body(userDTO);
    }
}
