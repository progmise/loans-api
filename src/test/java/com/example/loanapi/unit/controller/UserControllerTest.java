package com.example.loanapi.unit.controller;

import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.loanapi.constant.Paths;
import com.example.loanapi.controller.UserController;
import com.example.loanapi.dto.UserDTO;
import com.example.loanapi.model.Loan;
import com.example.loanapi.model.User;
import com.example.loanapi.payload.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private UserController userController;    
    
    @Autowired
    private ModelMapper modelMapper;
    
    User user;
    UserDTO userDTO;
    Loan loan;
    Loan otherLoan;
    ApiResponse apiResponse;
    ObjectMapper mapper;
    
    @Before
    public void setUp() {
    	
    	user = new User();
    	loan = new Loan();
    	otherLoan = new Loan();
    	
    	user.setId(new Long(3));
        user.setEmail("user3@example.com");
        user.setFirstName("Lope");
        user.setLastName("Casares");
        
        loan.setId(new Long(5));
        loan.setTotal(1928.57);        
        loan.setUser(user);
        
        otherLoan.setId(new Long(6));
        otherLoan.setTotal(46584.95);
        otherLoan.setUser(user);
    }
    
    @Test
    public void shouldGetOneUserWithNoneLoan() throws Exception {
    	
    	userDTO = modelMapper.map(user, UserDTO.class);

        BDDMockito.given(userController.getUserById(userDTO.getId())).willReturn(ResponseEntity.ok().body(userDTO));
        
        mvc.perform(MockMvcRequestBuilders.get(Paths.VERSION + Paths.USERS + userDTO.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(userDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.loans", IsCollectionWithSize.hasSize(0)));
    }     
    
    @Test
    public void shouldGetOneUserWithOneLoan() throws Exception {

    	user.getLoans().add(loan);
    	
    	userDTO = modelMapper.map(user, UserDTO.class);

        BDDMockito.given(userController.getUserById(userDTO.getId())).willReturn(ResponseEntity.ok().body(userDTO));

        mvc.perform(MockMvcRequestBuilders.get(Paths.VERSION + Paths.USERS + userDTO.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(userDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.loans", IsCollectionWithSize.hasSize(1)));
    }          
    
    @Test
    public void shouldGetOneUserWithTwoLoans() throws Exception {

    	user.getLoans().add(loan);
    	user.getLoans().add(otherLoan);
    	
    	userDTO = modelMapper.map(user, UserDTO.class);

        BDDMockito.given(userController.getUserById(userDTO.getId())).willReturn(ResponseEntity.ok().body(userDTO));

        mvc.perform(MockMvcRequestBuilders.get(Paths.VERSION + Paths.USERS + userDTO.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(userDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.loans", IsCollectionWithSize.hasSize(2)));
    }
    
    @Test
    public void shouldPostOneUserWithNoneLoan() throws Exception {
    	
    	mapper = new ObjectMapper();
    	userDTO = modelMapper.map(user, UserDTO.class);
    	
    	String json = mapper.writeValueAsString(userDTO);

        BDDMockito.given(userController.createUser(userDTO)).willReturn(new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED));
        
        mvc.perform(MockMvcRequestBuilders.post(Paths.VERSION + Paths.USERS)
        		.content(json)
                .contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(userDTO.getId().intValue())));
    }    
}
