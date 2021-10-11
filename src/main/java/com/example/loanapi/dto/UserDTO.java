package com.example.loanapi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDTO {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private List<LoanDTO> loans;
	
	public UserDTO() {
		
		super();
		loans = new ArrayList<LoanDTO>();
	}

	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public String getFirstName() {
		
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}

	public String getLastName() {
		
		return lastName;
	}

	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}

	public List<LoanDTO> getLoans() {
		
		return loans;
	}

	public void setLoans(List<LoanDTO> loans) {
		
		this.loans = loans;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(email, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		UserDTO other = (UserDTO) obj;
		
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", email=" + email + ", firstName=" + firstName 
				+ ", lastName=" + lastName + ", loans=" + loans + "]";
	}
}
