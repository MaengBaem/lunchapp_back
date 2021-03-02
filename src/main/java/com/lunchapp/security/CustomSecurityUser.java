package com.lunchapp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.lunchapp.model.Member;
import com.lunchapp.model.enums.ROLE;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomSecurityUser extends User {
	private static final long serialVersionUID = 1L;

	private static final String ROLE_PREFIX = "ROLE_";

	private String email;
	private String name;
	private GrantedAuthority authority;

	public CustomSecurityUser(Member member) {
		super(member.getUserName(), member.getPassword(), makeGrantedeAuth(member.getRole()));
		this.email = member.getEmail();
		this.name = member.getUserName();
		this.authority = new SimpleGrantedAuthority(ROLE_PREFIX + member.getRole().name());
	}

	private static List<GrantedAuthority> makeGrantedeAuth(ROLE role) {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.name()));
		return list;
	}
}
