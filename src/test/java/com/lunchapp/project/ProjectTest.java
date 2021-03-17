package com.lunchapp.project;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.model.dto.todolist.ProjectDto;
import com.lunchapp.model.todolist.Company;
import com.lunchapp.model.todolist.PSTATUS;
import com.lunchapp.model.todolist.Project;
import com.lunchapp.model.todolist.repository.CompanyRepository;
import com.lunchapp.model.todolist.repository.ProjectRepository;

@SpringBootTest
public class ProjectTest {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	CompanyRepository companyRepository;

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
//		Company companyA = companyRepository.findById(1L)
//				.orElseThrow(() -> new NoSearchObjectException("회사를 찾을 수 없음!"));
//		Project project = Project.builder().title("project1").desc("project1 desc").company(companyA)
//				.status(PSTATUS.PROCEEDING).startDate(LocalDateTime.now()).build();
//		projectRepository.save(project);
//		Company companyB = companyRepository.findById(2L)
//				.orElseThrow(() -> new NoSearchObjectException("회사를 찾을 수 없음!"));
//		Project project2 = Project.builder().title("project2").desc("project2 desc").company(companyB)
//				.status(PSTATUS.NOTSTARTED).startDate(LocalDateTime.now()).build();
//		projectRepository.save(project2);
//		Company companyC = companyRepository.findById(3L)
//				.orElseThrow(() -> new NoSearchObjectException("회사를 찾을 수 없음!"));
//		Project project3 = Project.builder().title("project3").desc("project3 desc").company(companyC)
//				.status(PSTATUS.COMPLETE).startDate(LocalDateTime.now()).build();
//		projectRepository.save(project3);
//		Company companyD = companyRepository.findById(4L)
//				.orElseThrow(() -> new NoSearchObjectException("회사를 찾을 수 없음!"));
//		Project project4 = Project.builder().title("project4").desc("project4 desc").company(companyD)
//				.status(PSTATUS.PROCEEDING).startDate(LocalDateTime.now()).build();
//		projectRepository.save(project4);
	}
}
