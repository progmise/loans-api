package com.example.loanapi.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanapi.dto.UserDTO;
import com.example.loanapi.exception.ResourceNotFoundException;
import com.example.loanapi.model.User;
import com.example.loanapi.repository.UsersRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private ModelMapper modelMapper;	
	
	@Autowired
	UsersRepository userRepository;	
	
	@Override
	public UserDTO getUserById(Long id) {
		
		Optional<User> optional = userRepository.findById(id);
		User user;
		UserDTO userDTO;
		
		try {
			
			user = optional.get();
			userDTO = modelMapper.map(user, UserDTO.class);
			
		}
		catch (NoSuchElementException ex) {
			
			throw new ResourceNotFoundException("User", "id", id);
		}
		
		
		return userDTO;
	}

	@Override
	public UserDTO createUser(User user) {
		
		User savedUser = userRepository.save(user);
		UserDTO userDTO = modelMapper.map(savedUser, UserDTO.class);
		
		return userDTO;
	}

	@Override
	public void deleteUser(User user) {
		
		userRepository.delete(user);
	}
}
