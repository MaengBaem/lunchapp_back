package com.lunchapp.model.todolist;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lunchapp.model.BaseTimeEntity;
import com.lunchapp.model.dto.todolist.ProjectDto;

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

	private PSTATUS projectStatus;

	public Project(ProjectDto dto) {
		this.title = dto.getTitle();
		this.desc = dto.getDesc();
		this.projectStatus = PSTATUS.valueOf(dto.getStatus());
//		this.startDate = dto.getStartDate() != null ? dto.getStartDate() : null;
//		this.endDate = dto.getEndDate() != null ? dto.getEndDate() : null;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}

	public void modify(ProjectDto dto) {
		this.title = dto.getTitle();
		this.desc = dto.getDesc();
		this.projectStatus = PSTATUS.valueOf(dto.getStatus());
//		this.startDate = dto.getStartDate() != null ? dto.getStartDate() : null;
//		this.endDate = dto.getEndDate() != null ? dto.getEndDate() : null;
	}
}
