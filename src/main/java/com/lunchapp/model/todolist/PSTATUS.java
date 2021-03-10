package com.lunchapp.model.todolist;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PSTATUS {
	COMPLETE("완료"), PROCEEDING("진행중"), NOTSTARTED("시작전");

	private String value;

}
