package com.lunchapp.model.dto;

import com.lunchapp.model.todolist.Project;

import lombok.Data;

@Data
public class ResponseDto {
	private String key;
	private String value;
	
	public ResponseDto(Project p) {
		this.key = p.getId().toString();
		this.value = p.getTitle();
	}
}
