package com.heying.hrmanager.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heying.hrmanager.pojo.User;
import com.heying.hrmanager.service.UserService;
import com.heying.hrmanager.utils.Tools;

@Controller
public class UserAction {
	@Resource
	UserService userService;
	@RequestMapping("/login")
	public String login(User user,HttpSession session) throws Exception{
		User loginUser=userService.login(user.getUsername(), user.getPassword(),user.getType());
		if(loginUser!=null){
			session.setAttribute(Tools.LOGIN_USER, loginUser);
//			if(user.getType().equals("admin")){
//				return "";
//			}else if(user.getType().equals("employee")){
//				return "";
//			}else if(user.getType().equals("guest")){
//				return "guest/addResume";
//			}else{
				return "forward:/index.jsp";
//			}
		}
		return "redirect:/login.jsp";
	}
	@RequestMapping("/register")
	public String register(User user,HttpSession session)throws Exception{
		user.setType("guest");
		User loginUser=userService.register(user);
		if(loginUser!=null){
			session.setAttribute(Tools.LOGIN_USER, loginUser);
		}
		return "forward:/index.jsp";
	}
	
}
