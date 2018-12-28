package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.heying.hrmanager.utils.Tools;

public class AppTest {

	@Test
	public void test() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND, 0);
		Date value1=calendar.getTime();
		System.out.println(value1.toString());
	}
	@Test
	public void test2() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND, 0);
		Date date1=calendar.getTime();
		System.out.println(date1);
		
		Date date2=Calendar.getInstance().getTime();
		System.out.println(date2);
		
		long h=Tools.intervalDate(date1, date2);
		System.out.println(h);
		System.out.println(date1.getDay());
	}
	@Test
	public void test3() throws ParseException {
		Calendar calendar=Calendar.getInstance();
		String strDate="09:00:00";
		Date date=new SimpleDateFormat("HH:mm:ss").parse(strDate);
		System.out.println(date);
	}

}
