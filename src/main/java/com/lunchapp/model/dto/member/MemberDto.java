package com.lunchapp.model.dto.member;

import com.lunchapp.model.member.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberDto {
	private String id;
	
	private String email;
	
	private String userName;
	
	private String password;
	
	private String role;
	
	private String roleId;
	
	public MemberDto(Member member) {
		this.id = member.getId().toString();
		this.email = member.getEmail();
		this.userName = member.getUserName();
		this.role = member.getRole().getValue();
		this.roleId = member.getRole().name();
	}
}
