package com.heying.hrmanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heying.hrmanager.mapper.PositionMapper;
import com.heying.hrmanager.pojo.Position;
import com.heying.hrmanager.pojo.PositionExample;

@Service
@Transactional
public class PositionService {

	@Resource
	private PositionMapper positionMapper;
	public void add(Position position) {
		positionMapper.insert(position);		
	}
	public Position getPositionById(Integer id) {
		return positionMapper.selectByPrimaryKey(id);
	}
	public void update(Position position) {
		positionMapper.updateByPrimaryKeySelective(position);
		
	}
	public List<Position> getAllPostionByDeptId(Integer deptId) {
		PositionExample example=new PositionExample();
		example.createCriteria().andDeptidEqualTo(deptId);
		List<Position> positionList=positionMapper.selectByExample(example);
		return positionList;
	}

}
