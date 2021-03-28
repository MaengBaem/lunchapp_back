package com.lunchapp.service.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lunchapp.constants.DBNAME;
import com.lunchapp.exception.DuplicateException;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.model.dto.BaseDto;
import com.lunchapp.model.dto.project.ProjectDto;
import com.lunchapp.model.project.Company;
import com.lunchapp.model.project.CompanyRepository;
import com.lunchapp.model.project.PSTATUS;
import com.lunchapp.model.project.Project;
import com.lunchapp.model.project.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	private final CompanyRepository companyRepository;

	public List<ProjectDto> createProject(ProjectDto dto)
			throws NumberFormatException, NoSearchObjectException, DuplicateException {
		checkDuplicateTitle(dto.getTitle());
		Project project = new Project(dto);
		if (dto.getCompanyId() != null) {
			Company company = companyRepository.findById(Long.valueOf(dto.getCompanyId()))
					.orElseThrow(() -> new NoSearchObjectException(DBNAME.PROJECT.getKrname()));
			project.setCompany(company);
		}
		projectRepository.save(project);
		return getAllProject();
	}

	public List<ProjectDto> deleteProject(ProjectDto dto) throws Exception {
		Project project = projectRepository.findById(Long.valueOf(dto.getId()))
				.orElseThrow(() -> new NoSearchObjectException(DBNAME.PROJECT.getKrname()));
		if (project.getProjectStatus() == PSTATUS.PROCEEDING)
			throw new Exception("진행중인 프로젝트는 삭제할 수 없습니다");

		projectRepository.delete(project);
		return getAllProject();
	}

	public List<ProjectDto> modifyProject(ProjectDto dto) throws NumberFormatException, NoSearchObjectException {
		Project project = projectRepository.findById(Long.valueOf(dto.getId()))
				.orElseThrow(() -> new NoSearchObjectException(DBNAME.PROJECT.getKrname()));
		project.modify(dto);
		if (dto.getCompanyId() != null) {
			Company company = companyRepository.findById(Long.valueOf(dto.getCompanyId()))
					.orElseThrow(() -> new NoSearchObjectException(DBNAME.COMPANY.getKrname()));
			project.setCompany(company);
		}
		return getAllProject();
	}

	@Transactional(readOnly = true)
	public List<ProjectDto> getAllProject() {
		List<ProjectDto> result = projectRepository.findAll().stream().map(ProjectDto::new)
				.collect(Collectors.toList());
		return result;
	}

	private void checkDuplicateTitle(String title) throws DuplicateException {
		Project duplicate = projectRepository.findByTitle(title);
		if (duplicate != null)
			throw new DuplicateException(title);
	}

	public Map<String, List<BaseDto>> getCreateProjectPrev() {
		Map<String, List<BaseDto>> result = new HashMap<String, List<BaseDto>>();
		List<BaseDto> companyList = companyRepository.findAll().stream()
				.map(c -> new BaseDto(c.getId().toString(), c.getName())).collect(Collectors.toList());
		result.put("companyList", companyList);
		List<BaseDto> statusList = new ArrayList<BaseDto>();
		for (PSTATUS status : PSTATUS.values()) {
			BaseDto bDto = new BaseDto(status.name(), status.getTitle());
			statusList.add(bDto);
		}
		result.put("statusList", statusList);
		return result;
	}
}
