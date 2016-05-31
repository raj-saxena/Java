package com.xyz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

/**
 * This class keeps the fare strategy Created by raj on 17/4/16.
 */
public class FareStrategy {

	private static final Map<String, Float> fareStrategyMap = new HashMap<>();
	static final String WEEKDAY = "WEEKDAY";
	static final String WEEKEND = "WEEKEND";

	static void initialize(Properties props) {
		fareStrategyMap.put(WEEKDAY, Float.parseFloat(Optional.ofNullable(props.getProperty(WEEKDAY)).orElse("7.0")));
		fareStrategyMap.put(WEEKEND, Float.parseFloat(Optional.ofNullable(props.getProperty(WEEKEND)).orElse("5.5")));
	}

	public static Float getFare() {
		Float fare = null;
		LocalDate date = LocalDate.now();
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		if (DayOfWeek.SATURDAY.equals(dayOfWeek) || DayOfWeek.SUNDAY.equals(dayOfWeek)) {
			fare = fareStrategyMap.get(WEEKEND);
		} else {
			fare = fareStrategyMap.get(WEEKDAY);
		}
		return fare;
	}
}
