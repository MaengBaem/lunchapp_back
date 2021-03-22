package com.lunchapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lunchapp.util.DateUtil;

@SpringBootTest
public class DateTest {

	@Test
	void datetime_to_string() {
		LocalDateTime today = LocalDateTime.now();
		String test = DateUtil.dateTimeToString(today);
		System.out.println(test);
	}

	@Test
	void string_to_datetime() {
		String test = "2021-03-18 21:05:14";
		LocalDateTime time = DateUtil.StringToDateTime(test);
		System.out.println(time);
	}

	@Test
	void date_to_string() {
		LocalDateTime today = LocalDateTime.now();
		String test = DateUtil.dateToString(today);
		System.out.println(test);
	}

	@Test
	void string_to_date() {
		String test = "2021-03-18";
		LocalDateTime time = DateUtil.StringToDate(test);
		System.out.println(time);
	}
}
