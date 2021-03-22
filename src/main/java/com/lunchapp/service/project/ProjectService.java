package com.lunchapp.service.project;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lunchapp.constants.Constants;
import com.lunchapp.exception.DuplicateException;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.model.dto.Result;
import com.lunchapp.model.dto.todolist.ProjectDto;
import com.lunchapp.model.project.Company;
import com.lunchapp.model.project.CompanyRepository;
import com.lunchapp.model.project.Project;
import com.lunchapp.model.project.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	private final CompanyRepository companyRepository;

	@Transactional(rollbackFor = Exception.class)
	public Result<List<ProjectDto>> createProject(ProjectDto dto) {
		try {
			checkDuplicateTitle(dto.getTitle());
			Project project = new Project(dto);
			if (dto.getCompanyId() != null) {
				Company company = companyRepository.findById(Long.valueOf(dto.getCompanyId()))
						.orElseThrow(() -> new NoSearchObjectException("회사"));
				project.setCompany(company);
			}
			projectRepository.save(project);
			return getAllProject();
		} catch (Exception e) {
			return new Result<List<ProjectDto>>(null, e.getMessage());
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public Result<List<ProjectDto>> deleteProject(ProjectDto dto) {
		try {
			Project project = projectRepository.findById(Long.valueOf(dto.getId()))
					.orElseThrow(() -> new NoSearchObjectException("프로젝트"));
			projectRepository.delete(project);
			return getAllProject();
		} catch (Exception e) {
			return new Result<List<ProjectDto>>(null, e.getMessage());
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public Result<List<ProjectDto>> modifyProject(ProjectDto dto) {
		try {
			Project project = projectRepository.findById(Long.valueOf(dto.getId()))
					.orElseThrow(() -> new NoSearchObjectException("프로젝트"));
			project.modify(dto);
			if (dto.getCompanyId() != null) {
				Company company = companyRepository.findById(Long.valueOf(dto.getCompanyId()))
						.orElseThrow(() -> new NoSearchObjectException("회사"));
				project.setCompany(company);
			}
			projectRepository.delete(project);
			return getAllProject();
		} catch (Exception e) {
			return new Result<List<ProjectDto>>(null, e.getMessage());
		}
	}

	public Result<List<ProjectDto>> getAllProject() {
		List<ProjectDto> result = projectRepository.findAll().stream().map(ProjectDto::new)
				.collect(Collectors.toList());
		return new Result<List<ProjectDto>>(result, Constants.RESULT_SUCCESS);
	}

	private void checkDuplicateTitle(String title) throws DuplicateException {
		Project duplicate = projectRepository.findByTitle(title);
		if (duplicate == null)
			throw new DuplicateException(title);
	}
}
