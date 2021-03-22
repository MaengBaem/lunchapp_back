package com.lunchapp.model.dto.todolist;

import com.lunchapp.model.project.Project;

import lombok.Data;

@Data
public class ProjectDto {
	private String id;

	private String title;

	private String desc;

	private String startDate;

	private String endDate;

	private String companyName;
	
	private String companyId;

	private String status;
	
	public ProjectDto(Project project) {
		this.id = project.getId().toString();
		this.title = project.getTitle();
		this.desc = project.getDesc();
		this.companyName = project.getCompany().getName();
		this.companyId = project.getCompany().getId().toString();
		this.status = project.getProjectStatus().name();
	}
}
