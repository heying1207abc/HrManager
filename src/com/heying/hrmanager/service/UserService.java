package com.heying.hrmanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heying.hrmanager.mapper.UserMapper;
import com.heying.hrmanager.pojo.User;
import com.heying.hrmanager.pojo.UserExample;
@Service
public class UserService {
	@Resource
	UserMapper userMapper;
	public User login(String username,String password,String type)throws Exception{
		UserExample example=new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password).andTypeEqualTo(type);
		List<User> userList=userMapper.selectByExample(example);
		return userList.size()>0?userList.get(0):null;
	}
	
	public User register(User user) throws Exception{		
		int row=userMapper.insert(user);
		if(row>0){
			return user;
		}
		return null;
	}

	public void updateType(Integer userId, String type) {
		User user=new User();
		user.setId(userId);
		user.setType(type);
		userMapper.updateByPrimaryKeySelective(user);
		
	}
}
