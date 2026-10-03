package com.example.loanapi.infrastructure.adapters.input.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.loanapi.application.usecases.CreateUserUseCase;
import com.example.loanapi.application.usecases.DeleteUserUseCase;
import com.example.loanapi.application.usecases.RetrieveUserUseCase;
import com.example.loanapi.domain.exception.ResourceNotFoundException;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.request.CreateUserRequest;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.UserResponse;
import com.example.loanapi.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private RetrieveUserUseCase retrieveUserUseCase;

	@MockBean
	private CreateUserUseCase createUserUseCase;

	@MockBean
	private DeleteUserUseCase deleteUserUseCase;

	private UserResponse userResponse;
	private ObjectMapper mapper;

	@Before
	public void setUp() {
		userResponse = new UserResponse(3L, "user3@example.com", "Lope", "Casares", null);
		mapper = new ObjectMapper();
	}

	@Test
	public void shouldGetUserById() throws Exception {
		given(retrieveUserUseCase.retrieveUser(3L)).willReturn(userResponse);

		mvc.perform(get(Constants.API_VERSION + Constants.USERS_PATH + "3")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.email").value("user3@example.com"));
	}

	@Test
	public void shouldCreateUser() throws Exception {
		given(createUserUseCase.createUser(any(CreateUserRequest.class))).willReturn(userResponse);

		CreateUserRequest request =
				new CreateUserRequest("user3@example.com", "Lope", "Casares");

		mvc.perform(post(Constants.API_VERSION + Constants.USERS_PATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(3));
	}

	@Test
	public void shouldDeleteUserById() throws Exception {
		mvc.perform(delete(Constants.API_VERSION + Constants.USERS_PATH + "3"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.success").value(true));
	}

	@Test
	public void shouldRejectNonNumericUserId() throws Exception {
		mvc.perform(get(Constants.API_VERSION + Constants.USERS_PATH + "abc"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors[0].code").value("invalid.value.user_id"));
	}

	@Test
	public void shouldReturnNotFoundForMissingUser() throws Exception {
		given(retrieveUserUseCase.retrieveUser(99L))
				.willThrow(new ResourceNotFoundException("User", "id", 99L));

		mvc.perform(get(Constants.API_VERSION + Constants.USERS_PATH + "99"))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.errors[0].code").value("user.not.found"));
	}

	@Test
	public void shouldRejectInvalidCreateUserBody() throws Exception {
		CreateUserRequest request = new CreateUserRequest("", "", "");

		mvc.perform(post(Constants.API_VERSION + Constants.USERS_PATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors[0].code").value("required.field.email"));
	}

	@Test
	public void shouldPropagateNotFoundOnDelete() throws Exception {
		doThrow(new ResourceNotFoundException("User", "id", 99L))
				.when(deleteUserUseCase).deleteUser(99L);

		mvc.perform(delete(Constants.API_VERSION + Constants.USERS_PATH + "99"))
				.andExpect(status().isNotFound());
	}
}
