package com.lunchapp.model.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum PSTATUS {
	COMPLETE("완료"), PROCEEDING("진행중"), NOTSTARTED("시작전");

	final private String title;
}
