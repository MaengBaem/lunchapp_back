package com.lunchapp.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ROLE {
	ADMIN("관리자"), USER("사원"), GUEST("비사원");

	private String value;

}
