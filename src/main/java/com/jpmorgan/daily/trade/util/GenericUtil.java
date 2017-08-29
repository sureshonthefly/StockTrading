/*******************************************************************************
 * Project Stock Trading
 * Copyright (c) 2016-2017
 * All rights reserved.
 *******************************************************************************/
package com.jpmorgan.daily.trade.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * The class to utility class
 * @author suresh
 *
 */
public class GenericUtil {

	/**
	 * The below are list of WeekEnd countries based on currency
	 */
	private static final List<String> sunWeekendDaysCountries = Arrays.asList(new String[]{"SGP"});
	private static final List<String> satWeekendDaysCountries = Arrays.asList(new String[]{"AED"});
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
	
	/**
	 * Convert Date string to Localtime object
	 * @param date in string format
	 * @return date in LocalDate format
	 */
	public static LocalDate convertStringIntoDate(String date){
		return LocalDate.parse(date, formatter);
	}
	/**
	 * Get the weekend day based on currency code
	 * @param currencyCode to get the Weekday codes
	 * @return the weekend code
	 */
	public static int[] getWeekendDays(String currencyCode){
		if(sunWeekendDaysCountries.contains(currencyCode)){
			return new int[]{DayOfWeek.SATURDAY.getValue(), DayOfWeek.SUNDAY.getValue()};
		}else if(satWeekendDaysCountries.contains(currencyCode)){
			return new int[]{DayOfWeek.FRIDAY.getValue(), DayOfWeek.SATURDAY.getValue()};
		}else{
			return new int[]{DayOfWeek.SATURDAY.getValue(), DayOfWeek.SUNDAY.getValue()};
		}
	}
	

	/**
	 * To get updated settlement date
	 * @param date the LocalDate object
	 * @param currencyCode input currency code
	 * @return updated LocalDate for settlement date
	 */
	public static LocalDate upateSettlementDate(LocalDate date, String currencyCode){
		int[] weekendArr = getWeekendDays(currencyCode);
		if(weekendArr.length ==2 && weekendArr[0] == date.getDayOfWeek().getValue()){
			date = date.plusDays(2);
		}else if(weekendArr.length ==2 && weekendArr[1] == date.getDayOfWeek().getValue()){
			date = date.plusDays(1);
		}else if(weekendArr.length ==1 && weekendArr[0] == date.getDayOfWeek().getValue()){
			date = date.plusDays(1);
		}
		return date;
	}
}
