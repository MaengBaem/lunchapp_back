package com.lunchapp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.lunchapp.model.member.Member;
import com.lunchapp.model.member.ROLE;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomSecurityUser extends User {
	private static final long serialVersionUID = 1L;

	private static final String ROLE_PREFIX = "ROLE_";

	private String email;
	private String name;
	private String id;
	
	private GrantedAuthority authority;

	public CustomSecurityUser(Member member) {
		super(member.getUserName(), member.getPassword(), makeGrantedeAuth(member.getRole()));
		this.id = member.getId().toString();
		this.name = member.getUserName();
		this.email = member.getEmail();
		this.authority = new SimpleGrantedAuthority(ROLE_PREFIX + member.getRole().name());
	}

	private static List<GrantedAuthority> makeGrantedeAuth(ROLE role) {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.name()));
		return list;
	}
}
