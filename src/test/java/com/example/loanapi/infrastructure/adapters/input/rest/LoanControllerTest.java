package com.example.loanapi.infrastructure.adapters.input.rest;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.loanapi.application.usecases.ListLoansUseCase;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.LoanResponse;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.PageResponse;
import com.example.loanapi.infrastructure.adapters.input.rest.dto.response.PagedResponse;
import com.example.loanapi.utils.Constants;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanController.class)
public class LoanControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ListLoansUseCase listLoansUseCase;

	private PagedResponse<LoanResponse> pagedResponse;

	@Before
	public void setUp() {
		LoanResponse loan = new LoanResponse(5L, 1928.57, 3L);
		LoanResponse otherLoan = new LoanResponse(6L, 46584.95, 3L);

		pagedResponse = new PagedResponse<>(
				Arrays.asList(loan, otherLoan),
				new PageResponse(1L, 50L, 2L));
	}

	@Test
	public void shouldListLoans() throws Exception {
		given(listLoansUseCase.listLoans(any(Integer.class), any(Integer.class)))
				.willReturn(pagedResponse);

		mvc.perform(get(Constants.API_VERSION + Constants.LOANS_PATH + "?page=1&size=50")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.items[0].id").value(5))
				.andExpect(jsonPath("$.items[1].total").value(46584.95))
				.andExpect(jsonPath("$.paging.total").value(2));
	}

	@Test
	public void shouldListLoansByUserId() throws Exception {
		given(listLoansUseCase.listLoansByUserId(eq(3L), any(Integer.class), any(Integer.class)))
				.willReturn(pagedResponse);

		mvc.perform(get(Constants.API_VERSION + Constants.LOANS_PATH + "?page=1&size=50&user_id=3")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.items[0].userId").value(3));
	}

	@Test
	public void shouldRejectInvalidPageSize() throws Exception {
		mvc.perform(get(Constants.API_VERSION + Constants.LOANS_PATH + "?page=1&size=999")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors[0].code").value("invalid.value.size"));
	}
}
