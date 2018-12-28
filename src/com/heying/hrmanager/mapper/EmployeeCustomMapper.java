package com.heying.hrmanager.mapper;

import java.util.List;

import com.heying.hrmanager.pojo.EmployeeCustom;
import com.heying.hrmanager.pojo.QueryVo;

public interface EmployeeCustomMapper {
	public List<EmployeeCustom> findAllEmployee()throws Exception;
	
	public List<EmployeeCustom> findAllEmployeeByRewardDate(QueryVo vo)throws Exception;
}
