package com.heying.hrmanager.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date> {
	DateFormat[] formats=new SimpleDateFormat[]{
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	};
	public Date convert(String arg0) {
		for(DateFormat format:formats){
			try{
				return format.parse(arg0);
			}catch(Exception ex){
				
			}
		}
		return null;
	}

}
