package com.heying.hrmanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heying.hrmanager.mapper.DeptMapper;
import com.heying.hrmanager.pojo.Dept;
import com.heying.hrmanager.pojo.DeptExample;

@Service
@Transactional
public class DeptService {
	@Resource
	DeptMapper deptMapper;
	public void add(Dept dept)throws Exception{
		deptMapper.insert(dept);
	}
	public List<Dept> getAllDept() {	
		DeptExample example=new DeptExample();
		
		return deptMapper.selectByExample(example);
	}
	public Dept getDeptById(Integer id) {
		return deptMapper.selectByPrimaryKey(id);
	}
	public void update(Dept dept) {
		deptMapper.updateByPrimaryKeySelective(dept);
		
	}
	public void deleteById(Integer id) {
		deptMapper.deleteByPrimaryKey(id);
		
	}
}
