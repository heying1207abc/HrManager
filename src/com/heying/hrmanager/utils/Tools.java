package com.heying.hrmanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

public class Tools {
	/**
	 * 登录用户
	 */
	public static final String LOGIN_USER="loginUser";
	/**
	 * 招聘每页个数
	 */
	public static final int RECRUIT_PAGE_SIZE=3;
	/**
	 * 简历每页个数
	 */
	public static final int RESUME_PAGE_SIZE=1;
	/**
	 * 上班状态正常
	 */
	public static final int ATTENDANCE_NOMAL=1;
	/**
	 * 迟到早退
	 */
	public static final int ATTENDANCE_LATE=2;
	/**
	 * 退到早退扣除金额
	 */
	public static final double ATTENDANCE_LATE_MONEY=-30;
	/**
	 * 旷工
	 */
	public static final int ATTENDANCE_ABS=3;
	/**
	 * 加班
	 */
	public static final int ATTENDANCE_OVERTIME=4;
	/**
	 * 考勤统计日期
	 */
	public static int ATTENDANCE_STATISTICS_DATE=30;
	
	//字符串转日期
	public static Date toDateFromString(String strDate) throws ParseException{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
	}
	/**
	 * 计算时间差，返回小时数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long intervalDate(Date nowDate,Date endDate){
		long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    return min>0?hour+1:hour;
	}
	/**
	 * 返回上班状态
	 */
	public int getAttendanceState(Date date,Date recordDate){
		if(recordDate==null){
			return Tools.ATTENDANCE_ABS;
		}
		long hour=intervalDate(date, recordDate);
		if(hour>=3){
			return Tools.ATTENDANCE_ABS;
		}else if(hour>0 && hour<3 ){
			return Tools.ATTENDANCE_LATE;
		}	
		
		if(recordDate.getDay()==6 || recordDate.getDay()==7){
			return Tools.ATTENDANCE_OVERTIME;
		}
		return Tools.ATTENDANCE_NOMAL;
	}
	/**
	 * 当前时间加一天的日期
	 */
	public static Date addDay(Date now){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
		return calendar.getTime();
	}
	/**
	 * 当前时间前一个月的日期
	 */
	public static Date prevMonth(Date now){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
		return calendar.getTime();
	}
}
