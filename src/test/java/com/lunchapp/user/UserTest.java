package com.lunchapp.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lunchapp.model.member.Member;
import com.lunchapp.model.member.MemberRepository;
import com.lunchapp.model.member.ROLE;

@SpringBootTest
public class UserTest {

	@Autowired
	private MemberRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void 어드민_생성() {
		String pw = "admin";
		String encryptPassword = passwordEncoder.encode(pw);
		Member user = Member.builder().email("email@test.com").userName("admin").password(encryptPassword)
				.role(ROLE.ADMIN).build();
		userRepository.save(user);

		assertThat(user.getUserName()).isEqualTo("admin");
		System.out.println(passwordEncoder.matches(pw, user.getPassword()));
	}
	
	@Test
	void 유저_생성() {
		String pw = "user";
		String encryptPassword = passwordEncoder.encode(pw);
		Member user = Member.builder().email("user@test.com").userName("user").password(encryptPassword)
				.role(ROLE.USER).build();
		userRepository.save(user);

		assertThat(user.getUserName()).isEqualTo("user");
		System.out.println(passwordEncoder.matches(pw, user.getPassword()));
	}
}
