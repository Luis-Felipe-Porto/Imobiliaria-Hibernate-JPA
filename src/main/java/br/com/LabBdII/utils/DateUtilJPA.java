package br.com.LabBdII.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilJPA {
	
	public static Long getConvertDate(String date) {
		DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		long dias = 0;
		try {
			Date dt = df.parse (date);
			dias= dt.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return dias;
	}
}
