package com.tatva.other.classes;

import java.util.Date;

public class GetDate {
	@SuppressWarnings("unused")
	public static Date getDateTime() {           

	    Date date = new Date(System.currentTimeMillis());

	    return date;
	}
}
