package com.heying.hrmanager.pojo;

import java.util.Date;

import com.heying.hrmanager.utils.Tools;

public class QueryVo {
	//招聘分页开始的索引
	private int recruitPageStart;	
	
	//招聘每页个数
	private int recruitPageSize=Tools.RECRUIT_PAGE_SIZE;
	
	//简历分页开始的索引
	private int resumePageStart;	
	private int resumePageSize=Tools.RESUME_PAGE_SIZE;
	//登录的用户id
	private Integer userId;
	//招聘信息id
	private Integer recruitId;
	//奖惩开始时间
	private Date rewardsBeginTime;
	//奖惩结束时间
	private Date rewardsEndTime;
	
	//简历
	private Resume resume;	
	//招聘扩展类
	private RecruitCustom recruitCustom;
	//部门
	private Dept dept;
	//职位
	private Position position;
	
	
	

	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getRewardsBeginTime() {
		return rewardsBeginTime;
	}

	public void setRewardsBeginTime(Date rewardsBeginTime) {
		this.rewardsBeginTime = rewardsBeginTime;
	}

	public Date getRewardsEndTime() {
		return rewardsEndTime;
	}

	public void setRewardsEndTime(Date rewardsEndTime) {
		this.rewardsEndTime = rewardsEndTime;
	}

	public RecruitCustom getRecruitCustom() {
		return recruitCustom;
	}

	public void setRecruitCustom(RecruitCustom recruitCustom) {
		this.recruitCustom = recruitCustom;
	}

	public int getRecruitPageStart() {
		return recruitPageStart;
	}

	public void setRecruitPageStart(int recruitPageStart) {
		this.recruitPageStart = recruitPageStart;
	}

	public int getRecruitPageSize() {
		return recruitPageSize;
	}

	public int getResumePageStart() {
		return resumePageStart;
	}

	public void setResumePageStart(int resumePageStart) {
		this.resumePageStart = resumePageStart;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public int getResumePageSize() {
		return resumePageSize;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRecruitId() {
		return recruitId;
	}

	public void setRecruitId(Integer recruitId) {
		this.recruitId = recruitId;
	}

	public Integer getUserId() {
		return userId;
	}

	
}
