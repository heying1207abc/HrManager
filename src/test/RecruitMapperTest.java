package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heying.hrmanager.mapper.AttendanceflowingCustomMapper;
import com.heying.hrmanager.mapper.RecruitCustomMapper;
import com.heying.hrmanager.mapper.RecruitMapper;
import com.heying.hrmanager.mapper.ResumeCustomMapper;
import com.heying.hrmanager.mapper.ResumeMapper;
import com.heying.hrmanager.pojo.EmployeeCustom;
import com.heying.hrmanager.pojo.QueryVo;
import com.heying.hrmanager.pojo.Recruit;
import com.heying.hrmanager.pojo.RecruitCustom;
import com.heying.hrmanager.pojo.Resume;
import com.heying.hrmanager.service.AttendanceService;
import com.heying.hrmanager.service.EmployeeService;
import com.heying.hrmanager.service.RecruitService;
import com.heying.hrmanager.utils.Tools;

public class RecruitMapperTest {
	ApplicationContext context=new ClassPathXmlApplicationContext("bean_dao.xml","bean_springmvc.xml");
	@Test
	public void testInsert() {
		RecruitMapper recruitMapper=(RecruitMapper) context.getBean("recruitMapper");
		Recruit recruit=new Recruit();
		recruit.setDeptid(2);
		recruit.setPostionid(1);
		recruit.setPostion("出纳");
		recruit.setPublishdate(new Date());
		recruitMapper.insert(recruit);
	}
	@Test
	public void testFind() throws Exception {
		RecruitCustomMapper recruitCustomMapper=(RecruitCustomMapper) context.getBean("recruitCustomMapper");
		QueryVo vo=new QueryVo();
		
		
		
		List<RecruitCustom> list=recruitCustomMapper.findAllRecruitCustomByPage(vo);
		System.out.println(list);
	}
	@Test
	public void testResume() throws Exception {
		ResumeCustomMapper resumeCustomMapper=(ResumeCustomMapper) context.getBean("resumeCustomMapper");
		QueryVo vo=new QueryVo();
		
		Resume resume=new Resume();
		resume.setUserid(1);
		vo.setResume(resume);
		vo.setResumePageStart((1-1)*Tools.RESUME_PAGE_SIZE);			
		List<Resume> list= resumeCustomMapper.findAllResumeByPage(vo);
		System.out.println(list);
	}
	
	@Test
	public void testRecruitAndResumeList() throws Exception {
//		RecruitCustomMapper recruitCustomMapper=(RecruitCustomMapper) context.getBean("recruitCustomMapper");
		QueryVo vo=new QueryVo();
		RecruitService recruitService=(RecruitService) context.getBean("recruitService");
		List<RecruitCustom> list=recruitService.getRecruitAndResumeList(1);
		System.out.println(list);
	}
	
	@Test
	public void test6() throws Exception {
		EmployeeService employeeService=(EmployeeService) context.getBean("employeeService");
		
	}

}
