package com.lunchapp.model.dto.todolist;

import com.lunchapp.model.project.Company;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyDto {
	
	private String id;
	private String companyName;
	
	public CompanyDto(Company company) {
		this.id = company.getId().toString();
		this.companyName = company.getName();
	}
}
