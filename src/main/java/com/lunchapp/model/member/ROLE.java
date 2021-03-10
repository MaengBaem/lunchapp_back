package com.lunchapp.model.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ROLE {
	ADMIN("관리자"), USER("사원");

	private String value;

}
