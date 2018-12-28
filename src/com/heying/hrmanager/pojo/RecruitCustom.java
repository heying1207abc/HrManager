package com.heying.hrmanager.pojo;

import java.util.List;

import com.heying.hrmanager.action.ResumeAction;

public class RecruitCustom extends Recruit {
	private Dept dept;
	private Position deptPosition;
	private List<ResumeCustom> resumes;
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Position getDeptPosition() {
		return deptPosition;
	}
	public void setDeptPosition(Position deptPosition) {
		this.deptPosition = deptPosition;
	}
	public List<ResumeCustom> getResumes() {
		return resumes;
	}
	public void setResumes(List<ResumeCustom> resumes) {
		this.resumes = resumes;
	}
	
}
