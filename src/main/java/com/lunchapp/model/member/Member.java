package com.lunchapp.model.member;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.lunchapp.model.BaseTimeEntity;
import com.lunchapp.model.dto.member.MemberDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

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

	public void modify(MemberDto dto) {
		this.email = dto.getEmail();
		this.userName = dto.getUserName();
		this.role = ROLE.valueOf(dto.getRoleId());
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
}
