package com.lunchapp.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lunchapp.model.Member;
import com.lunchapp.model.enums.ROLE;
import com.lunchapp.repository.MemberRepository;

@SpringBootTest
public class UserTest {

	@Test
	void 이넘_테스트() {
		System.out.println(ROLE.valueOf("ADMIN"));
		System.out.println(ROLE.ADMIN.name());// ADMIN
		System.out.println(ROLE.ADMIN.toString()); // ADMIN
		System.out.println(ROLE.ADMIN.getValue()); // 관리자
	}

	@Autowired
	private MemberRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void 유저_생성() {
		String pw = "user_pw";
		String encryptPassword = passwordEncoder.encode(pw);
		Member user = Member.builder().email("email@test.com").userName("user_name").password(encryptPassword)
				.role(ROLE.USER).build();
		userRepository.save(user);
		
		assertThat(user.getUserName()).isEqualTo("user_name");
		System.out.println(passwordEncoder.matches(pw, user.getPassword()));
	}
}
