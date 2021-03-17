package com.lunchapp.exception;

public class DuplicateException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateException(String error, String string) {
		super("이미 존재하는 아이템입니다 (ID/NAME) : " + error + "/" + string);
	}

	public DuplicateException(String name) {
		super("동일 이름이 존재합니다 : " + name);
	}
}
