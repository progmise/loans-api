package com.example.loanapi.dto;

import java.util.Objects;

public class LoanDTO {

	private Long id;
	private Double total;
	private Long userId;

	public LoanDTO() {
		
		super();
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

	public Long getUserId() {
		
		return userId;
	}

	public void setUserId(Long userId) {
		
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id, total, userId);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		LoanDTO other = (LoanDTO) obj;
		
		return Objects.equals(id, other.id) && Objects.equals(total, other.total)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		
		return "LoanDTO [id=" + id + ", total=" + total + ", userId=" + userId + "]";
	}
}
