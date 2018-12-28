package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.heying.hrmanager.mapper.UserMapper;
import com.heying.hrmanager.pojo.User;
import com.heying.hrmanager.pojo.UserExample;
import com.heying.hrmanager.pojo.UserExample.Criteria;
import com.heying.hrmanager.pojo.UserExample.Criterion;
import com.heying.hrmanager.service.AttendanceService;

public class UserTest {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean_dao.xml","bean_springmvc.xml");
		AttendanceService attendanceService=(AttendanceService) context.getBean("attendanceService");
		
		attendanceService.statistics(new Date(), 1);
	}
	@Test
	public void test2() {
		Date now=new Date();
		System.out.println(now.getDate());
	}
	

}
