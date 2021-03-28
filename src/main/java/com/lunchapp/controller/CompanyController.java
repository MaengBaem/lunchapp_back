package com.lunchapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.model.dto.project.CompanyDto;
import com.lunchapp.service.project.CompanyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/company")
@RestController
public class CompanyController {

	private final CompanyService companyService;

	@PostMapping("/create")
	public ResponseEntity<List<CompanyDto>> createCompany(@RequestBody CompanyDto dto) throws Exception {
		List<CompanyDto> result = companyService.createCompany(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/modify")
	public ResponseEntity<List<CompanyDto>> modifyCompany(@RequestBody CompanyDto dto) throws Exception {
		List<CompanyDto> result = companyService.modifyCompany(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<List<CompanyDto>> deleteCompany(@RequestBody CompanyDto dto) throws Exception {
		List<CompanyDto> result = companyService.deleteCompany(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<CompanyDto>> getCompanyList() throws Exception {
		List<CompanyDto> result = companyService.getAllCompany();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
