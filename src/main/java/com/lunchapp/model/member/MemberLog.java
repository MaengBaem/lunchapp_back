package com.lunchapp.model.member;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lunchapp.model.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class MemberLog extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member")
	private Member member;

	private LocalDateTime loginTime;
	
	private LocalDateTime logoutTime;

	public MemberLog(Member member, LocalDateTime loginTime) {
		this.member = member;
		this.loginTime = loginTime;
	}
	
	public void logout(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}
}
