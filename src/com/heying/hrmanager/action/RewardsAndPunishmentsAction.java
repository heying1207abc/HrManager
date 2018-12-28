package com.heying.hrmanager.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heying.hrmanager.pojo.Dept;
import com.heying.hrmanager.pojo.EmployeeCustom;
import com.heying.hrmanager.service.DeptService;
import com.heying.hrmanager.service.EmployeeService;
import com.heying.hrmanager.service.PositionService;

@Controller
public class RewardsAndPunishmentsAction {
	@Resource
	private DeptService deptService;
	@Resource
	private PositionService positionService;
	@Resource
	private EmployeeService employeeService;
	
	@ModelAttribute("deptList")
	public List<Dept> getDepts(){
		return deptService.getAllDept();
	}
	
	@RequestMapping("/rewardsAndPunishments")
	public String rewardsAndPunishments(){
		return "admin/rewardsAndPunishments";
	}
	
	@RequestMapping("/getRewardsAndPunishments")
	public String getRewardsAndPunishments(Date rewardsBeginTime,Date rewardsEndTime,Integer deptId,Integer postionId,Model model) throws Exception{
		List<EmployeeCustom> empList=employeeService.getAllEmployee(rewardsBeginTime, rewardsEndTime, deptId, postionId);
		model.addAttribute("empList", empList);
		return "admin/rewardsAndPunishments";
	}
}
