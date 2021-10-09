package com.example.loanapi.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="LOAN")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TOTAL")
	@NonNull
	private Double total;
	
	@ManyToOne
	@NonNull
	private User user;

	public Loan() {
		
		super();
	}

	public Loan(Long id, Double total) {
		
		super();
		this.id = id;
		this.total = total;
	}

	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
	}

	public Double getTotal() {
		
		return total;
	}

	public void setTotal(Double total) {
		
		this.total = total;
	}

	public User getUser() {
		
		return user;
	}

	public void setUser(User user) {
		
		this.user = user;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id, total, user);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Loan other = (Loan) obj;
		
		return Objects.equals(id, other.id) && Objects.equals(total, other.total) && Objects.equals(user, other.user);
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("{\"class\": ").append("\"Loan\"");

		if (id != null) {
			
			sb.append(", ");
			sb.append("\"id\": ");
			sb.append("\"");
			sb.append(id);
			sb.append("\"");
		}
		
		if (total != null) {
			
			sb.append(", ");
			sb.append("\"total\": ");
			sb.append("\"");
			sb.append(total);
			sb.append("\"");
		}
		
		if (user != null) {
			
			sb.append(", ");
			sb.append("\"user\": ");
			sb.append("\"");
			sb.append(user);
			sb.append("\"");
		}
		
		sb.append("}");	
		
		return sb.toString();
	}	
}
