package com.lunchapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.exception.DuplicateException;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.model.dto.BaseDto;
import com.lunchapp.model.dto.project.ProjectDto;
import com.lunchapp.service.project.ProjectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/project")
@RestController
public class ProjectController {

	private final ProjectService projectService;

	@PostMapping("/create")
	public ResponseEntity<List<ProjectDto>> createPorject(@RequestBody ProjectDto dto)
			throws NumberFormatException, NoSearchObjectException, DuplicateException {
		List<ProjectDto> result = projectService.createProject(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<List<ProjectDto>> deleteProject(@RequestBody ProjectDto dto) throws Exception {
		List<ProjectDto> result = projectService.deleteProject(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/modify")
	public ResponseEntity<List<ProjectDto>> modifyProject(@RequestBody ProjectDto dto)
			throws NumberFormatException, NoSearchObjectException {
		List<ProjectDto> result = projectService.modifyProject(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProjectDto>> getProjectList() {
		List<ProjectDto> result = projectService.getAllProject();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/prev")
	public ResponseEntity<Map<String, List<BaseDto>>> getCreateProjectPrev() {
		Map<String, List<BaseDto>> result = projectService.getCreateProjectPrev();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
