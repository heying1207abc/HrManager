package com.heying.hrmanager.pojo;

import java.util.Date;

public class ResumeCustom extends Resume{
	private Date interviewTime;
	private String consult;
	private String entry;
	public Date getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}
	public String getConsult() {
		return consult;
	}
	public void setConsult(String consult) {
		this.consult = consult;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	
}
