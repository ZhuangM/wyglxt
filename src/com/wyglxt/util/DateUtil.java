package com.wyglxt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class DateUtil {
	private static final Logger log = Logger.getLogger(DateUtil.class);

	public static Date str2Date(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error(str + "格式错误.");
			e.printStackTrace();
		}
		return date;
	}

	public static String date2Str(Date date) {
		String str = null;
		if (null == date) {
			log.error("date is null.");
			return str;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		str = sdf.format(date);
		return str;
	}

	public static String getNextMonth(String str) {
		if (!StringUtils.isNotBlank(str)) {
			log.error("str is null.");
			return null;
		}

		StringBuilder sb = new StringBuilder();
		String[] temp = str.split("-");
		int nextMonth = Integer.parseInt(temp[1]) + 1;
		if (nextMonth > 12) {
			long year = Long.parseLong(temp[0]);
			year++;
			return year + "-01-01";
		}
		sb.append(temp[0]);
		sb.append("-");
		sb.append(nextMonth);
		sb.append("-01");

		return sb.toString();
	}

	public static String getLastDate(String str) {
		if (!StringUtils.isNotBlank(str)) {
			log.error("str is null.");
			return null;
		}

		String[] temp = str.split("-");
		switch (temp[1]) {
		case "01":
			return temp[0] + "-" + temp[1] + "-31";
		case "02":
			long year = Long.parseLong(temp[0]);
			if (year % 4 == 0 || year % 400 == 0) {
				return temp[0] + "-" + temp[1] + "-29";
			} else {
				return temp[0] + "-" + temp[1] + "-28";
			}
		case "03":
			return temp[0] + "-" + temp[1] + "-31";
		case "04":
			return temp[0] + "-" + temp[1] + "-30";
		case "05":
			return temp[0] + "-" + temp[1] + "-31";
		case "06":
			return temp[0] + "-" + temp[1] + "-30";
		case "07":
			return temp[0] + "-" + temp[1] + "-31";
		case "08":
			return temp[0] + "-" + temp[1] + "-31";
		case "09":
			return temp[0] + "-" + temp[1] + "-30";
		case "10":
			return temp[0] + "-" + temp[1] + "-31";
		case "11":
			return temp[0] + "-" + temp[1] + "-30";
		case "12":
			return temp[0] + "-" + temp[1] + "-31";
		default:
			break;
		}

		return null;
	}
}
