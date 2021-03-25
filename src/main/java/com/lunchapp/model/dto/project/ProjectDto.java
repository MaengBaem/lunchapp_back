package com.lunchapp.model.dto.project;

import com.lunchapp.model.project.Project;
import com.lunchapp.util.DateUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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
	
	private String statusId;

	public ProjectDto(Project project) {
		this.id = project.getId().toString();
		this.title = project.getTitle();
		this.desc = project.getDesc();
		this.companyName = project.getCompany().getName();
		this.companyId = project.getCompany().getId().toString();
		this.status = project.getProjectStatus().getTitle();
		this.statusId = project.getProjectStatus().name();
		this.startDate = project.getStartDate() != null ? DateUtil.dateTimeToStringDate(project.getStartDate()) : null;
		this.endDate = project.getEndDate() != null ? DateUtil.dateTimeToStringDate(project.getEndDate()) : null;
	}
}
