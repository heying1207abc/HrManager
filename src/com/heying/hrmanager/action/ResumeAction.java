package com.heying.hrmanager.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.heying.hrmanager.mapper.ResumeMapper;
import com.heying.hrmanager.pojo.RecruitCustom;
import com.heying.hrmanager.pojo.Resume;
import com.heying.hrmanager.service.ResumeService;
import com.heying.hrmanager.utils.Tools;
@Controller
public class ResumeAction {
	@Resource
	private ResumeService resumeService;
	//跳转到添加页面
	@RequestMapping("/addResume")
	public String addResume(){
		return "guest/addResume";
	}
	//添加简历
	@RequestMapping("/resumeAdd")
	public String resumeAdd(Resume resume){
		resumeService.add(resume);
		return "guest/addResume";
	}
	//提交简历给招聘信息
	@RequestMapping("/resumeSubmit")
	public String resumeSubmit(Model model,Integer id,Integer recruitid){
		Resume resume=resumeService.getResumeById(id);
		resumeService.addRecruitByResume(id,recruitid);		
		model.addAttribute("recruitId", recruitid);
		model.addAttribute("resume", resume);
		return "guest/resumeList";
	}
	
	@RequestMapping("/resumeListByUserId")
	public String resumeListByUserId(Integer userId,Model model) throws Exception{
		List<Resume> resumeList=resumeService.getResumeListByUserId(userId);
		model.addAttribute("resumeList", resumeList);
		return "guest/resumeList";
	}
	//简历分页显示，一次显示一条
	@RequestMapping("/resumeListByUserIdAndPage")
	public String resumeListByUserIdAndPage(@RequestParam(defaultValue="1") int pageNum,Integer userId,Integer recruitId,Model model)throws Exception{
		int count=resumeService.getResumeListByUserIdCount(userId);
		int pageSize=count/Tools.RESUME_PAGE_SIZE;
		if(count%Tools.RESUME_PAGE_SIZE!=0){
			pageSize++;
		}
		if(pageNum<1){
			pageNum=1;
		}
		if(pageNum>pageSize){
			pageNum=pageSize;
		}
		Resume resume=resumeService.getResumeListByUserIdAndPage(userId,pageNum);
		model.addAttribute("resume", resume);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("count",pageSize);
		model.addAttribute("recruitId", recruitId);
		return "guest/resumeList";
	}
	
	@InitBinder
	public void webBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
}
