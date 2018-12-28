package com.heying.hrmanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heying.hrmanager.mapper.RecruitandresumeMapper;
import com.heying.hrmanager.mapper.ResumeCustomMapper;
import com.heying.hrmanager.mapper.ResumeMapper;
import com.heying.hrmanager.pojo.QueryVo;
import com.heying.hrmanager.pojo.RecruitCustom;
import com.heying.hrmanager.pojo.Recruitandresume;
import com.heying.hrmanager.pojo.Resume;
import com.heying.hrmanager.pojo.ResumeExample;
import com.heying.hrmanager.utils.Tools;

@Service
@Transactional
public class ResumeService {
	@Resource
	private ResumeMapper resumeMapper;
	@Resource
	private ResumeCustomMapper resumeCustomMapper;
	@Resource
	private RecruitandresumeMapper recruitandresumeMapper;

	//添加简历
	public void add(Resume resume){
		resumeMapper.insert(resume);
	}
	//申请招聘
	public void addRecruitByResume(Integer resumeId,Integer recruitId){
		Recruitandresume record=new Recruitandresume();
		
		record.setRecruitid(recruitId);
		record.setResumeid(resumeId);
		//更改招聘与简历关系表，添加投递信息
		recruitandresumeMapper.insertSelective(record);
	}
	//得到分页条数
	public int getResumeListByUserIdCount(Integer userId){
		ResumeExample example=new ResumeExample();
		example.createCriteria().andUseridEqualTo(userId);	
		return resumeMapper.countByExample(example);
	}
	public List<Resume> getResumeListByUserId(Integer userId)throws Exception{
		ResumeExample example=new ResumeExample();
		example.createCriteria().andUseridEqualTo(userId);		
		return resumeMapper.selectByExample(example);
	}
	//分页
	public Resume getResumeListByUserIdAndPage(Integer userId, int pageNum)
			throws Exception {
		QueryVo vo = new QueryVo();
		Resume resume = new Resume();
		resume.setUserid(userId);
		vo.setResume(resume);
		vo.setResumePageStart((pageNum - 1) * vo.getResumePageSize());
		List<Resume> list = resumeCustomMapper.findAllResumeByPage(vo);
		return list.size()>0?list.get(0):null;
	}
	public Resume getResumeById(Integer id) {
		return resumeMapper.selectByPrimaryKey(id);
	}
	
}
