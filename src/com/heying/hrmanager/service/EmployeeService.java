package com.heying.hrmanager.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heying.hrmanager.mapper.EmployeeCustomMapper;
import com.heying.hrmanager.mapper.EmployeeMapper;
import com.heying.hrmanager.mapper.EmployeebakMapper;
import com.heying.hrmanager.mapper.UserMapper;
import com.heying.hrmanager.pojo.Dept;
import com.heying.hrmanager.pojo.EmployeeCustom;
import com.heying.hrmanager.pojo.Employeebak;
import com.heying.hrmanager.pojo.Position;
import com.heying.hrmanager.pojo.QueryVo;
import com.heying.hrmanager.pojo.User;
@Service
@Transactional
public class EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;
	@Resource
	private EmployeeCustomMapper employeeCustomMapper;
	@Resource
	private EmployeebakMapper employeebakMapper;
	@Resource
	private UserMapper userMapper;
	
	public void add(EmployeeCustom employee,Integer userId)throws Exception{
		employeeMapper.insert(employee);
		User record=new User();
		record.setId(userId);
		record.setEmployeeid(employee.getId());
		userMapper.updateByPrimaryKeySelective(record);
	}
	public void update(EmployeeCustom employee)throws Exception{
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	public void deleteById(Integer id,String reason)throws Exception{
		Employeebak record=new Employeebak();
		record.setEmployeeid(id);
		record.setReason(reason);
		employeebakMapper.insert(record);
		employeeMapper.deleteByPrimaryKey(id);
	}
	public List<EmployeeCustom> getAllEmployee() throws Exception{
		return employeeCustomMapper.findAllEmployee();
	}
	/**
	 * 得到所有员工在某时间段的奖惩信息
	 * @param rewardsAndPunishmentTime
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeCustom> getAllEmployee(Date rewardsBeginTime,Date rewardsEndTime,Integer deptId,Integer postionId) throws Exception{
		QueryVo vo=new QueryVo();
		if(rewardsBeginTime!=null && rewardsEndTime!=null){
			vo.setRewardsBeginTime(rewardsBeginTime);
			vo.setRewardsEndTime(rewardsEndTime);
		}
		if(deptId!=null){
			Dept dept=new Dept();
			dept.setId(deptId);
			vo.setDept(dept);
		}
		if(postionId!=null){
			Position position=new Position();
			position.setId(postionId);
			vo.setPosition(position);
		}
		
		return employeeCustomMapper.findAllEmployeeByRewardDate(vo);
	}
}
