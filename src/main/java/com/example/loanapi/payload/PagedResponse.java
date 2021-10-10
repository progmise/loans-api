package com.example.loanapi.payload;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.loanapi.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PagedResponse<T> {
	
	private List<T> items;
	private PageDTO page;

	public PagedResponse() {
		
		super();
	}

	public PagedResponse(List<T> items, PageDTO page) {
		
		setItems(items);
		
		this.page = page;
	}
	
	public List<T> getItems() {
		
		return items == null ? null : new ArrayList<>(items);
	}

	public final void setItems(List<T> items) {
		
		if (items == null) {
			
			this.items = null;
		} 
		else {
			
			this.items = Collections.unmodifiableList(items);
		}
	}

	@JsonProperty("paging")
	public PageDTO getPage() {
		
		return page;
	}

	public void setPage(PageDTO page) {
		
		this.page = page;
	}
}