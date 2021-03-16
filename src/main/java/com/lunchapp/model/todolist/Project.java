package com.lunchapp.model.todolist;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lunchapp.model.BaseTimeEntity;

import lombok.Builder;
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

	@Builder
	public Project(String title, String desc, Company company, PSTATUS status, LocalDateTime startDate,
			LocalDateTime endDate) {
		this.title = title;
		this.desc = desc;
		this.company = company;
		this.projectStatus = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
