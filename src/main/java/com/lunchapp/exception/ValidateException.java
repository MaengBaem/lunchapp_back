package com.lunchapp.exception;

public class ValidateException extends Exception {
	private static final long serialVersionUID = 1L;

	public ValidateException(String email, String name) {
		super("동일한 이메일 혹은 이름이 존재합니다 : " + email + "/" + name);
	}

	public ValidateException(String err) {
		super(err);
	}
}
