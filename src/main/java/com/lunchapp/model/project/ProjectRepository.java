package com.lunchapp.model.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {


	Project findByTitle(String title);

	List<Project> findByCompany(Company company);


}
