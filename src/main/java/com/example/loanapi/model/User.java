package com.example.loanapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	private List<Loan> loans;
	
	public User() {
		
		super();
		loans = new ArrayList<Loan>();
	}

	public User(Long id, String email, String firstName, String lastName) {
		
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		loans = new ArrayList<Loan>();
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

	public List<Loan> getLoans() {
		
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		
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
		
		User other = (User) obj;
		
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("{\"class\": ").append("\"User\"");

		if (id != null) {
			
			sb.append(", ");
			sb.append("\"id\": ");
			sb.append("\"");
			sb.append(id);
			sb.append("\"");
		}
		
		if (email != null) {
			
			sb.append(", ");
			sb.append("\"email\": ");
			sb.append("\"");
			sb.append(email);
			sb.append("\"");
		}
		
		if (firstName != null) {
			
			sb.append(", ");
			sb.append("\"firstName\": ");
			sb.append("\"");
			sb.append(firstName);
			sb.append("\"");
		}
		
		if (lastName != null) {
			
			sb.append(", ");
			sb.append("\"lastName\": ");
			sb.append("\"");
			sb.append(lastName);
			sb.append("\"");
		}
		
		if (loans != null) {
			
			sb.append(", ");
			sb.append("\"loans\": ");
			sb.append("[");
			
			int i = 0;
			
			while (i < loans.size()) {
				
				sb.append(loans.get(i));
				i++;
			}
			
			sb.append("]");
		}
		
		sb.append("}");	
		
		return sb.toString();
	}
}
