package com.lunchapp.service.project;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lunchapp.constants.DBNAME;
import com.lunchapp.exception.DuplicateException;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.model.dto.project.CompanyDto;
import com.lunchapp.model.project.Company;
import com.lunchapp.model.project.CompanyRepository;
import com.lunchapp.model.project.Project;
import com.lunchapp.model.project.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Service
public class CompanyService {

	private final CompanyRepository companyRepository;
	private final ProjectRepository projectRepository;

	public List<CompanyDto> createCompany(CompanyDto dto) throws Exception {
		try {
			checkDuplicateName(dto.getCompanyName());
			Company company = new Company(dto.getCompanyName());
			companyRepository.save(company);
			return getAllCompany();
		} catch (DuplicateException e) {
			throw new DuplicateException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<CompanyDto> deleteCompany(CompanyDto dto) throws Exception {
		try {
			Company company = companyRepository.findById(Long.valueOf(dto.getId()))
					.orElseThrow(() -> new NoSearchObjectException(DBNAME.COMPANY.getKrname()));
			List<Project> project = projectRepository.findByCompany(company);
			if (project.size() > 0)
				throw new Exception("관련 프로젝트가 있어 삭제할 수 없습니다!");
			companyRepository.delete(company);
			return getAllCompany();
		} catch (NoSearchObjectException e) {
			throw new NoSearchObjectException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<CompanyDto> modifyCompany(CompanyDto dto) throws Exception {
		try {
			Company company = companyRepository.findById(Long.valueOf(dto.getId()))
					.orElseThrow(() -> new NoSearchObjectException(DBNAME.COMPANY.getKrname()));
			company.changeName(dto.getCompanyName());
			return getAllCompany();
		} catch (NoSearchObjectException e) {
			throw new NoSearchObjectException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Transactional(readOnly = true)
	public List<CompanyDto> getAllCompany() throws DuplicateException {
		List<CompanyDto> result = companyRepository.findAll().stream().map(CompanyDto::new)
				.collect(Collectors.toList());
		return result;
	}

	private void checkDuplicateName(String name) throws DuplicateException {
		Company duplicate = companyRepository.findByName(name);
		if (duplicate != null)
			throw new DuplicateException(name);
	}
}
