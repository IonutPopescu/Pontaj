package com.metrotraining.excuse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class GetDate {
	public String getDateAsString(long date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.US);

		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/Central"));
		calendar.setTimeInMillis(date);

		return sdf.format(calendar.getTime());
	}
	
	public Long getDateAsLong(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date dateLong = null;
		try {
			dateLong = sdf.parse(date.replace('T', ' '));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dateLong.getTime();
	}
}
