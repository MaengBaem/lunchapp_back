package com.lunchapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lunchapp.model.member.ROLE;
import com.lunchapp.model.project.PSTATUS;

@SpringBootTest
class LunchappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void 이넘_테스트() {
		System.out.println(ROLE.valueOf("ADMIN"));
		System.out.println(ROLE.ADMIN.name());// ADMIN
		System.out.println(ROLE.ADMIN.toString()); // ADMIN
		System.out.println(ROLE.ADMIN.getValue()); // 관리자
	}

}
