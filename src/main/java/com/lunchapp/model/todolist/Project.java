package com.lunchapp.model.todolist;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String desc;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	// 회사 하나당 여러 프로젝트를 가질 수 있음
	@OneToMany
	@JoinColumn(name = "company")
	private Company company;

	private PSTATUS projectStatus;
}
