package com.lunchapp.model.dto.todolist;

import com.lunchapp.model.todolist.Company;

import lombok.Data;

@Data
public class CompanyDto {
	
	private String id;
	private String name;
	
	public CompanyDto(Company company) {
		this.id = company.getId().toString();
		this.name = company.getName();
	}
}
