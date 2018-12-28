package com.heying.hrmanager.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heying.hrmanager.pojo.Dept;
import com.heying.hrmanager.service.DeptService;

@Controller
public class DeptAction {
	
	@Resource
	private DeptService deptService;
	
	@ModelAttribute("deptList")
	public List<Dept> getAllDept(){
		return deptService.getAllDept();
	}
	@RequestMapping("/deptAddOper")
	public String addDeptOper() throws Exception{
		return "company/addDept";
	}
	@RequestMapping("/deptListOper")
	public String listDeptOper(Model model) throws Exception{
		List<Dept> deptList=deptService.getAllDept();
		model.addAttribute("deptList", deptList);
		return "company/deptList";
	}
	@RequestMapping("/deptEditOper")
	public String editDeptOper(Integer id,Model model) throws Exception{
		Dept dept=deptService.getDeptById(id);
		model.addAttribute("dept", dept);
		return "company/editDept";
	}
	@RequestMapping("/addDept")
	public String addDept(Dept dept) throws Exception{
		dept.setCreatetime(new Date());
		deptService.add(dept);
		return "redirect:deptAddOper.action";
	}
	@RequestMapping("/editDept")
	public String editDept(@ModelAttribute("dept") Dept dept) throws Exception{
		deptService.update(dept);
		return "redirect:deptListOper.action";
	}
	@RequestMapping("/deleteDept")
	public String deleteDept(Integer id) throws Exception{
		deptService.deleteById(id);
		return "redirect:deptListOper.action";
	}
}
