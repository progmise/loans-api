package com.example.loanapi.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"page", "size", "total"})
public class PageDTO {
	
	private Long pageNumber;
	private Long size;
	private Long totalElements;	
	
	public PageDTO() {
		
		super();
	}
	
	@JsonProperty("page")
	public Long getPageNumber() {
		
		return pageNumber + 1;
	}

	public void setPageNumber(Long pageNumber) {
		
		this.pageNumber = pageNumber;
	}

	public Long getSize() {
		
		return size;
	}

	public void setSize(Long size) {
		
		this.size = size;
	}

	@JsonProperty("total")
	public Long getTotalElements() {
		
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		
		this.totalElements = totalElements;
	}	
	
	@Override
	public int hashCode() {
		
		return Objects.hash(pageNumber, size, totalElements);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		PageDTO other = (PageDTO) obj;
		
		return Objects.equals(pageNumber, other.pageNumber) && Objects.equals(size, other.size)
				&& Objects.equals(totalElements, other.totalElements);
	}

	@Override
	public String toString() {
		
		return "PageDTO [page=" + pageNumber + ", size=" + size + ", total=" + totalElements + "]";
	}
}
