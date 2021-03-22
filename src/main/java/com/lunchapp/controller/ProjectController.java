package com.lunchapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.model.dto.Result;
import com.lunchapp.model.dto.todolist.ProjectDto;
import com.lunchapp.service.project.ProjectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/project")
@RestController
public class ProjectController {

	private final ProjectService projectService;

	@PostMapping("/add")
	public void createPorject(@RequestBody ProjectDto dto) {
		projectService.createProject(dto);
	}

	@PostMapping("/delete")
	public Result<List<ProjectDto>> deleteProject(@RequestBody ProjectDto dto) {
		return projectService.deleteProject(dto);
	}

	@PostMapping("/modify")
	public Result<List<ProjectDto>> modifyProject(@RequestBody ProjectDto dto) {
		return projectService.modifyProject(dto);
	}
	
	@GetMapping("/all")
	public Result<List<ProjectDto>> getProjectList() {
		return projectService.getAllProject();
	}
}
