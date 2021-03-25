package com.lunchapp.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	public static final String TIME_FORMAT_STRING = " 00:00:00";

	public static String dateTimeToStringDate(LocalDateTime dateTime) {
		return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public static LocalDateTime StringToDate(String dateTime) {
		return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public static String dateTimeToString(LocalDateTime dateTime) {
		return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public static LocalDateTime StringToDateTime(String dateTime) {
		return LocalDateTime.parse(dateTime + TIME_FORMAT_STRING, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
