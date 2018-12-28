package com.heying.hrmanager.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heying.hrmanager.pojo.EmployeeCustom;
import com.heying.hrmanager.service.EmployeeService;

@Controller
public class EmployeeAction {
	@Resource
	private EmployeeService employeeService;
	
	@RequestMapping("/employeeList")
	public String EmployeeList(Model model) throws Exception{
		List<EmployeeCustom> employeeList=employeeService.getAllEmployee();
		model.addAttribute("employeeList", employeeList);
		return "company/employeeList";
	}
}
