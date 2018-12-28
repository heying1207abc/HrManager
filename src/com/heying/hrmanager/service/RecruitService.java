package com.heying.hrmanager.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heying.hrmanager.mapper.RecruitCustomMapper;
import com.heying.hrmanager.mapper.RecruitMapper;
import com.heying.hrmanager.mapper.RecruitandresumeMapper;
import com.heying.hrmanager.pojo.QueryVo;
import com.heying.hrmanager.pojo.Recruit;
import com.heying.hrmanager.pojo.RecruitCustom;
import com.heying.hrmanager.pojo.RecruitExample;
import com.heying.hrmanager.pojo.Recruitandresume;
import com.heying.hrmanager.pojo.RecruitandresumeExample;
import com.heying.hrmanager.pojo.Resume;
import com.heying.hrmanager.utils.Tools;

@Service
@Transactional
public class RecruitService {
	@Resource
	private RecruitMapper recruitMapper;
	@Resource
	private RecruitandresumeMapper recruitandresumeMapper;
	@Resource
	private RecruitCustomMapper recruitCustomMapper;

	public void add(Recruit recruit) throws Exception {
		recruit.setPublishdate(new Date());
		recruitMapper.insert(recruit);
	}

	// 修改招聘信息中对应的简历已阅读
	public void updateRecruitAndResume(Integer recruitId, Integer resumeId) {
		Recruitandresume record = new Recruitandresume();
		record.setConsult("Y");
		RecruitandresumeExample example = new RecruitandresumeExample();
		example.createCriteria().andRecruitidEqualTo(recruitId)
				.andResumeidEqualTo(resumeId);

		recruitandresumeMapper.updateByExampleSelective(record, example);
	}

	// 修改招聘信息中对应的简历面试时间
	public void updateRecruitInterviewTime(String interviewTime,
			Integer recruitId, Integer resumeId) throws Exception {
		Recruitandresume record = new Recruitandresume();
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.parse(interviewTime);
		record.setInterviewtime(date);
		RecruitandresumeExample example = new RecruitandresumeExample();
		example.createCriteria().andRecruitidEqualTo(recruitId)
				.andResumeidEqualTo(resumeId);

		recruitandresumeMapper.updateByExampleSelective(record, example);
	}

	// 得到数据的总条数
	public int getCount() throws Exception {
		RecruitExample example = new RecruitExample();
		return recruitMapper.countByExample(example);
	}

	public List<RecruitCustom> getAllRecruit() throws Exception {
		QueryVo vo = new QueryVo();
		return recruitCustomMapper.findAllRecruitCustom(vo);
	}

	public RecruitCustom getRecruitById(Integer id) throws Exception {
		QueryVo vo = new QueryVo();
		RecruitCustom recruitCustom = new RecruitCustom();
		recruitCustom.setId(id);
		vo.setRecruitCustom(recruitCustom);

		List<RecruitCustom> list = recruitCustomMapper.findAllRecruitCustom(vo);
		return list.size() > 0 ? list.get(0) : null;
	}

	// 分页
	public List<RecruitCustom> getAllRecruitAndPage(int pageNum)
			throws Exception {
		QueryVo vo = new QueryVo();
		vo.setRecruitPageStart((pageNum - 1) * Tools.RECRUIT_PAGE_SIZE);

		List<RecruitCustom> list = recruitCustomMapper
				.findAllRecruitCustomByPage(vo);
		return list;
	}
	/**
	 * 管理员得到所有的招聘及简历信息
	 * @return
	 * @throws Exception
	 */
	public List<RecruitCustom> getRecruitAndResumeList() throws Exception {
		QueryVo vo = new QueryVo();
		return recruitCustomMapper.findRecruitAndResumeList(vo);
	}
	/**
	 * 用户查看自已的面试信息
	 * @param userId
	 * @param recruitId
	 * @return
	 * @throws Exception 
	 */
	public List<RecruitCustom> getRecruitAndResumeList(Integer userId,
			Integer recruitId) throws Exception {
		QueryVo vo = new QueryVo();
		vo.setUserId(userId);
		vo.setRecruitId(recruitId);
		return recruitCustomMapper.findRecruitAndResumeList(vo);
	}
	public List<RecruitCustom> getRecruitAndResumeList(Integer userId) throws Exception {
		QueryVo vo = new QueryVo();
		vo.setUserId(userId);
		return recruitCustomMapper.findRecruitAndResumeList(vo);
	}
	/**
	 * 录用
	 * @param recruitId
	 * @param resumeId
	 * @throws Exception
	 */
	public void updateRecruitAndResumeByEntry(Integer recruitId,
			Integer resumeId) throws Exception {
		Recruitandresume record=new Recruitandresume();
		record.setEntry("Y");
		RecruitandresumeExample example=new RecruitandresumeExample();
		example.createCriteria().andRecruitidEqualTo(recruitId)
		.andResumeidEqualTo(resumeId);
		recruitandresumeMapper.updateByExampleSelective(record, example);
		
	}

}
