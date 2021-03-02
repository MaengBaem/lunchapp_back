package com.lunchapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.userdetails.UserDetails;

import com.lunchapp.model.enums.ROLE;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String userName;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private ROLE role;
	
	@Builder
	public Member(String email, String userName, String password, ROLE role) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
}