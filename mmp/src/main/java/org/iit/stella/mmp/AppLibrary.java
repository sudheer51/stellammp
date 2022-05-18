package org.iit.stella.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AppLibrary {

	public static String getFutureDate(int noofDays,String format)
	{
		//hard code the values
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,noofDays);
		System.out.println("To Date:" + cal.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
		
	}
}
