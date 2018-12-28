package com.heying.hrmanager.mapper;

public interface AttendanceflowingCustomMapper {
	//通过考勤流水号得到需修改的考勤状态
	public int findStateByBeginTime(Integer id);
	//通过上班打卡时间及员工id得到当考勤流水号
	public Integer findIdByBeginTime(Integer employeeId);
}
