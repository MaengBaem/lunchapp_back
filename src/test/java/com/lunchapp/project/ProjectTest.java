package com.lunchapp.project;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.model.dto.project.ProjectDto;
import com.lunchapp.model.project.Company;
import com.lunchapp.model.project.CompanyRepository;
import com.lunchapp.model.project.PSTATUS;
import com.lunchapp.model.project.Project;
import com.lunchapp.model.project.ProjectRepository;

@SpringBootTest
public class ProjectTest {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	CompanyRepository companyRepository;
	
	@Transactional
	@Rollback(false)
	@Test
	void 삭제() {
		companyRepository.deleteAll();
		projectRepository.deleteAll();
	}
	

	@Transactional
	@Rollback(false)
	@Test
	void 회사_생성() {
		Company companyA = new Company("companyA");
		Company companyB = new Company("companyB");
		Company companyC = new Company("companyC");
		Company companyD = new Company("companyD");
		companyRepository.save(companyA);
		companyRepository.save(companyB);
		companyRepository.save(companyC);
		companyRepository.save(companyD);
	}

	@Transactional
	@Rollback(false)
	@Test
	void 프로젝트_생성() throws NoSearchObjectException {
		Company companyA = companyRepository.findById(1L)
				.orElseThrow(() -> new NoSearchObjectException("회사를 찾을 수 없음!"));
		Project project = new Project("project1","project1 desc",companyA,PSTATUS.PROCEEDING);
		projectRepository.save(project);
		
		Company companyB = companyRepository.findById(2L)
				.orElseThrow(() -> new NoSearchObjectException("회사를 찾을 수 없음!"));
		Project project2 = new Project("project2","project2 desc",companyB,PSTATUS.NOTSTARTED);
		
		Project project3 = new Project("project3","project3 desc",companyB,PSTATUS.COMPLETE);
		projectRepository.save(project3);
		
		Company companyD = companyRepository.findById(4L)
				.orElseThrow(() -> new NoSearchObjectException("회사를 찾을 수 없음!"));
		Project project4 = new Project("project4","project4 desc",companyD,PSTATUS.PROCEEDING);
		projectRepository.save(project4);
	}
}
