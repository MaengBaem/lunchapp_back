package com.lunchapp.model.project;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lunchapp.model.BaseTimeEntity;
import com.lunchapp.model.dto.project.ProjectDto;
import com.lunchapp.util.DateUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Project extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String desc;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	@ManyToOne
	@JoinColumn(name = "company")
	private Company company;

	@Enumerated(EnumType.STRING)
	private PSTATUS projectStatus;

	public Project(ProjectDto dto) {
		this.title = dto.getTitle();
		this.desc = dto.getDesc();
		this.projectStatus = PSTATUS.valueOf(dto.getStatus());
		this.startDate = dto.getStartDate() != null ? DateUtil.StringToDateTime(dto.getStartDate()) : null;
		this.endDate = dto.getEndDate() != null ? DateUtil.StringToDateTime(dto.getEndDate()) : null;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void modify(ProjectDto dto) {
		this.title = dto.getTitle();
		this.desc = dto.getDesc();
		this.projectStatus = PSTATUS.valueOf(dto.getStatusId());
		this.startDate = dto.getStartDate() != null ? DateUtil.StringToDateTime(dto.getStartDate()) : null;
		this.endDate = dto.getEndDate() != null ? DateUtil.StringToDateTime(dto.getEndDate()) : null;
	}

	public Project(String title, String desc, Company companyA, PSTATUS proceeding) {
		this.title = title;
		this.desc = desc;
		this.company = companyA;
		this.projectStatus = proceeding;
	}
}
