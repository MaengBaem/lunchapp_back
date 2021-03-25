package com.lunchapp.model.dto.member;

import lombok.Data;

@Data
public class MemberDto {
	private String id;
	
	private String email;
	
	private String userName;
	
	private String password;
	
	private String role;
	
}
