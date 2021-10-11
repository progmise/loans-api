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
	private UsersRepository userRepository;	
	
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
	public UserDTO createUser(UserDTO userDTO) {
		
		User userRequest = modelMapper.map(userDTO, User.class);
		User user = userRepository.save(userRequest);
		UserDTO userResponse = modelMapper.map(user, UserDTO.class);
		
		return userResponse;
	}

	@Override
	public void deleteUserById(Long id) {
		
		userRepository.deleteById(id);
	}
}
