package com.heying.hrmanager.pojo;

import java.util.List;

public class EmployeeCustom extends Employee {
	private Dept dept;
	private Position position;
	private Employeestate state;
	private List<Rewardsandpunishments> rewardsandpunishments;
	
	public List<Rewardsandpunishments> getRewardsandpunishments() {
		return rewardsandpunishments;
	}
	public void setRewardsandpunishments(
			List<Rewardsandpunishments> rewardsandpunishments) {
		this.rewardsandpunishments = rewardsandpunishments;
	}
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
	public Employeestate getState() {
		return state;
	}
	public void setState(Employeestate state) {
		this.state = state;
	}
	
	
}
