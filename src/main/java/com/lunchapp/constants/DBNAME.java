package com.lunchapp.constants;

import lombok.Getter;

@Getter
public enum DBNAME {
	PROJECT("프로젝트", "project"), COMPANY("회사", "company"), MEMBER("계정", "member");

	final private String krname;
	final private String dbname;

	DBNAME(String krname, String dbname) {
		this.krname = krname;
		this.dbname = dbname;
	}
}
