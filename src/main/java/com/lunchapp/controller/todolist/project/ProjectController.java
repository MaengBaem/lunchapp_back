package com.lunchapp.controller.todolist.project;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.model.dto.Result;
import com.lunchapp.model.dto.todolist.CompanyDto;
import com.lunchapp.model.dto.todolist.ProjectDto;
import com.lunchapp.service.todolist.project.CompanyService;
import com.lunchapp.service.todolist.project.ProjectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/project")
@RestController
public class ProjectController {

	private final ProjectService projectService;
	private final CompanyService companyService;

	@PostMapping("/company-add")
	public Result<List<CompanyDto>> createCompany(@RequestBody CompanyDto dto) {
		return companyService.createCompany(dto);
	}

	@PostMapping("/company-modify")
	public Result<List<CompanyDto>> modifyCompany(@RequestBody CompanyDto dto) {
		return companyService.modifyCompany(dto);
	}

	@PostMapping("/company-delete")
	public Result<List<CompanyDto>> deleteCompany(@RequestBody CompanyDto dto) {
		return companyService.getAllCompany();
	}

	@GetMapping("/company-all")
	public Result<List<CompanyDto>> getCompanyList() {
		return companyService.getAllCompany();
	}

	// 프로젝트 생성
	@PostMapping("/project-add")
	public void createPorject(@RequestBody ProjectDto dto) {
		projectService.createProject(dto);
	}

	// 프로젝트 삭제
	@PostMapping("/project-delete")
	public Result<List<ProjectDto>> deleteProject(@RequestBody ProjectDto dto) {
		return projectService.deleteProject(dto);
	}

	// 프로젝트 수정
	@PostMapping("/project-modify")
	public Result<List<ProjectDto>> modifyProject(@RequestBody ProjectDto dto) {
		return projectService.modifyProject(dto);
	}
	
	// 프로젝트 조회 (테이블 형식)
	@GetMapping("/project-all")
	public Result<List<ProjectDto>> getProjectList() {
		return projectService.getAllProject();
	}
}
