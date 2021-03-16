package com.lunchapp.exception;

public class NoSearchObjectException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoSearchObjectException(String error) {
		super(error + "이(가) 존재하지 않습니다");
	}
}
