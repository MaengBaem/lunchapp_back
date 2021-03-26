package com.lunchapp.exception;

public class DuplicateException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateException(String email, String name) {
		super("동일한 이메일 혹은 이름이 존재합니다 : " + email + "/" + name);
	}

	public DuplicateException(String name) {
		super("동일 이름이 존재합니다 : " + name);
	}
}
