package com.lunchapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.model.dto.Result;
import com.lunchapp.model.dto.project.CompanyDto;
import com.lunchapp.service.project.CompanyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/company")
@RestController
public class CompanyController {

	private final CompanyService companyService;

	@PostMapping("/create")
	public Result<List<CompanyDto>> createCompany(@RequestBody CompanyDto dto) {
		return companyService.createCompany(dto);
	}

	@PostMapping("/modify")
	public Result<List<CompanyDto>> modifyCompany(@RequestBody CompanyDto dto) {
		return companyService.modifyCompany(dto);
	}

	@PostMapping("/delete")
	public Result<List<CompanyDto>> deleteCompany(@RequestBody CompanyDto dto) {
		return companyService.deleteCompany(dto);
	}

	@GetMapping("/all")
	public Result<List<CompanyDto>> getCompanyList() {
		return companyService.getAllCompany();
	}
}
