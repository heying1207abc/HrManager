package com.heying.hrmanager.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heying.hrmanager.pojo.Employee;
import com.heying.hrmanager.pojo.EmployeeCustom;
import com.heying.hrmanager.pojo.User;
import com.heying.hrmanager.service.AttendanceService;
import com.heying.hrmanager.service.EmployeeService;
import com.heying.hrmanager.utils.Tools;

@Controller
public class AttendanceAction {
	@Resource
	AttendanceService attendanceService;
	@Resource
	EmployeeService employeeService;
	// 显示打卡页面
	@RequestMapping("attendaceDisplay")
	public String attendaceDisplay() {
		return "employee/attendaceDisplay";
	}

	// 更改上班时间
	@RequestMapping("/attendanceUpdate")
	public @ResponseBody
	String attendanceUpdate(HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute(Tools.LOGIN_USER);
		attendanceService.addUp(new Date(), loginUser.getEmployeeid());
		return "OK";
	}

	// 更改下班时间
	@RequestMapping("/attendanceUpdate2")
	public @ResponseBody String attendanceUpdate2(HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute(Tools.LOGIN_USER);

		attendanceService.addOff(new Date(), loginUser.getEmployeeid());
		return "OK";
	}
	//统计考勤
	@RequestMapping("/statistics")
	public String statistics(Date date) throws Exception{
		int day=Tools.ATTENDANCE_STATISTICS_DATE;//每月统计日期，默认值30
		if(date.getDate()!=day){
			throw new Exception("不是统计日期");
		}
		List<EmployeeCustom> empList=employeeService.getAllEmployee();
		for(Employee emp:empList){
			attendanceService.statistics(date, emp.getId());
		}
		return "success";
	}
}
