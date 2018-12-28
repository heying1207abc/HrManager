package com.heying.hrmanager.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heying.hrmanager.pojo.Dept;
import com.heying.hrmanager.pojo.Employee;
import com.heying.hrmanager.pojo.EmployeeCustom;
import com.heying.hrmanager.pojo.Position;
import com.heying.hrmanager.pojo.Recruit;
import com.heying.hrmanager.pojo.RecruitCustom;
import com.heying.hrmanager.pojo.Resume;
import com.heying.hrmanager.service.DeptService;
import com.heying.hrmanager.service.EmployeeService;
import com.heying.hrmanager.service.PositionService;
import com.heying.hrmanager.service.RecruitService;
import com.heying.hrmanager.service.ResumeService;
import com.heying.hrmanager.service.UserService;
import com.heying.hrmanager.utils.Tools;

@Controller
public class RecruitAction {
	@Resource
	private DeptService deptService;
	@Resource
	private PositionService positionService;
	@Resource
	private RecruitService recruitService;
	@Resource
	private ResumeService resumeService;
	@Resource
	private UserService userService;
	@Resource
	private EmployeeService employeeService;
	
	@ModelAttribute("deptList")
	public List<Dept> getAllDept(){
		return deptService.getAllDept();
	}
	@RequestMapping("/getAllPositionByDept")
	public @ResponseBody List<Position> getAllPositionByDept(Integer deptId){
		List<Position> positionList=positionService.getAllPostionByDeptId(deptId);
		return positionList;
	}
	@RequestMapping("/recruitAddOper")
	public String recruitAddOper() throws Exception{
		return "company/addRecruit";
	}
	@RequestMapping("/addRecruit")
	public String addRecruit(Recruit recruit,HttpServletRequest request) throws Exception{
		recruitService.add(recruit);
		return "company/addRecruit";
	}
	@RequestMapping("/recruitList")
	public String recruitList(@RequestParam(defaultValue="1") int pageNum,Model model)throws Exception{
		int count=recruitService.getCount();
		int pageSize=count/Tools.RECRUIT_PAGE_SIZE;
		if(count%Tools.RECRUIT_PAGE_SIZE!=0){
			pageSize++;
		}
		if(pageNum<1){
			pageNum=1;
		}
		if(pageNum>pageSize){
			pageNum=pageSize;
		}
		List<RecruitCustom> recruitList=recruitService.getAllRecruitAndPage(pageNum);
		model.addAttribute("recruitList", recruitList);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("count",pageSize);
		return "guest/recruitList";
	}
	@RequestMapping("/recruitDetailOper")
	public String recruitDetailOper(Integer id,Model model) throws Exception{
		RecruitCustom recruitCustom=recruitService.getRecruitById(id);
		model.addAttribute("recruitCustom", recruitCustom);
		return "guest/detailRecruit";
	}

	//管理员得到招聘及简历信息
	@RequestMapping("/adminRecuritList")
	public String adminRecuritList(Model model) throws Exception{
		List<RecruitCustom> recuritCustomList=recruitService.getRecruitAndResumeList();
		model.addAttribute("recruitList", recuritCustomList);
		return "guest/recruitList";
	}
	//管理员查看简历
	@RequestMapping("/detailResume")
	public String adminDetailResume(Integer resumeId,Integer recruitId, Model model) throws Exception {
		Resume resume = resumeService.getResumeById(resumeId);
		// 修改招聘与简历的是否阅读为Y
		recruitService.updateRecruitAndResume(recruitId, resumeId);
		
		model.addAttribute("resume", resume);		
		model.addAttribute("recruitId", recruitId);
		
		return "guest/detailResume";
	}
	//管理员发送面试通知
	@RequestMapping("/sendNotice")
	public @ResponseBody String adminSendNotice(String interviewTime,Integer resumeId,Integer recruitId) throws Exception{
		recruitService.updateRecruitInterviewTime(interviewTime, recruitId, resumeId);
		return "success！";
	}
	//用户查看面试通知
	@RequestMapping("/getNotice")
	public  String guestGetNotice(Integer userId,Model model) throws Exception{
		List<RecruitCustom> list=recruitService.getRecruitAndResumeList(userId);
		model.addAttribute("recruitList", list);
		return "guest/noiceRecruitList";
	}
	//用户确定面试
	@RequestMapping("/okInterview")
	public String okInterview(Integer userId,Integer recruitId,Integer resumeId) throws Exception{
		recruitService.updateRecruitAndResumeByEntry(recruitId, resumeId);
		userService.updateType(userId,"employee");
		
		EmployeeCustom employee=new EmployeeCustom();
		Resume resume=resumeService.getResumeById(resumeId);
		RecruitCustom recruit=recruitService.getRecruitById(recruitId);
		
		employee.setBirthdate(resume.getBirthday());
		employee.setDeptid(recruit.getDeptid());
		employee.setEmpName(resume.getName());
		employee.setGender(resume.getGender());
		employee.setHirdate(new Date());
		employee.setPositionid(recruit.getPostionid());
		employee.setSalary(2000.0);
		employee.setStateid(3);
		employee.setResumeid(resumeId);
		
		employeeService.add(employee,userId);
		
		return "success";
	}
	
	
}
