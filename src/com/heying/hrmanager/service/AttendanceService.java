package com.heying.hrmanager.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heying.hrmanager.mapper.AttendanceMapper;
import com.heying.hrmanager.mapper.AttendanceflowingCustomMapper;
import com.heying.hrmanager.mapper.AttendanceflowingMapper;
import com.heying.hrmanager.mapper.AttendancestateMapper;
import com.heying.hrmanager.mapper.EmployeeMapper;
import com.heying.hrmanager.mapper.RewardsandpunishmentsMapper;
import com.heying.hrmanager.pojo.Attendance;
import com.heying.hrmanager.pojo.AttendanceExample;
import com.heying.hrmanager.pojo.Attendanceflowing;
import com.heying.hrmanager.pojo.AttendanceflowingExample;
import com.heying.hrmanager.pojo.Rewardsandpunishments;
import com.heying.hrmanager.utils.Tools;

@Service
@Transactional
public class AttendanceService {
	@Resource
	AttendanceMapper attendanceMapper;
	@Resource
	AttendancestateMapper attendancestateMapper;
	@Resource
	AttendanceflowingMapper attendanceflowingMapper;
	@Resource
	AttendanceflowingCustomMapper attendanceflowingCustomMapper;
	@Resource
	RewardsandpunishmentsMapper rewardsandpunishmentsMapper;
	@Resource
	EmployeeMapper employeeMapper;

	// 上班打卡
	public void addUp(Date now, Integer employeeId) throws Exception {
		Attendanceflowing record = new Attendanceflowing();
		record.setBegintime(now);
		record.setEmployeeid(employeeId);

		// 插入上班打卡记录
		attendanceflowingMapper.insertSelective(record);
		// 得到状态
		int state = attendanceflowingCustomMapper.findStateByBeginTime(record
				.getId());

		record.setState(state);
		// 修改状态
		attendanceflowingMapper.updateByPrimaryKeySelective(record);

	}

	// 下班打卡
	public void addOff(Date now, Integer employeeId) throws Exception {
		Attendanceflowing record = new Attendanceflowing();
		// 得到考勤流水号
		Integer id = attendanceflowingCustomMapper
				.findIdByBeginTime(employeeId);

		record.setEndtime(now);
		if (id != null) {
			record.setId(id);
			// 修改考勤流水
			attendanceflowingMapper.updateByPrimaryKeySelective(record);
		} else {
			// throw new Exception("上班未打卡，当天旷工");
			// 上班未打卡，添加考勤
			attendanceflowingMapper.insertSelective(record);
		}
		// 得到状态
		int state = attendanceflowingCustomMapper.findStateByBeginTime(record
				.getId());
		record.setState(state);
		// 修改状态
		attendanceflowingMapper.updateByPrimaryKeySelective(record);
		// 添加奖惩表
		writeRewardsandpunishments(state, employeeId,now);

	}

	/**
	 *  更新奖惩表
	 * @param state---奖惩原因（旷工。。。）
	 * @param employeeId---员工id
	 * @param date---奖惩日期
	 */
	private void writeRewardsandpunishments(int state, Integer employeeId,Date date) {
		// 通过员工id查询员工的基本工资
		double salary = employeeMapper.selectByPrimaryKey(employeeId)
				.getSalary();

		double money = 0.0;//奖惩金额
		switch (state) {
		case Tools.ATTENDANCE_LATE:// 迟到早退
			money = Tools.ATTENDANCE_LATE_MONEY;
			break;
		case Tools.ATTENDANCE_ABS:// 旷工
			money = -salary / 21.75;
			break;
		case Tools.ATTENDANCE_OVERTIME:// 加班
			money = salary / 21.75;
			break;
		}
		if (state != Tools.ATTENDANCE_NOMAL) {
			Rewardsandpunishments rewardsRecord = new Rewardsandpunishments();
			rewardsRecord.setEmployeeid(employeeId);
			rewardsRecord.setMoney(money);
			rewardsRecord.setReason(state + "");
			rewardsRecord.setRewardsandpunishmentstime(date);
			rewardsandpunishmentsMapper.insert(rewardsRecord);
		}

	}

	/**
	 * 
	 * @param date 统计日期
	 * @param employeeId，员工编号
	 */
	// 管理员统计，又不是周六，周日，则为旷工
	public void statistics(Date date, int employeeId) {
		// 得到上个月的今天
		Date beginDate = Tools.prevMonth(date);
		// 查询打卡记录
		AttendanceflowingExample example = new AttendanceflowingExample();
		example.createCriteria().andBegintimeBetween(beginDate, date)
				.andEmployeeidEqualTo(employeeId);
		List<Attendanceflowing> list = attendanceflowingMapper
				.selectByExample(example);
		// 添加未加入的日期
		List<Map<Date, Integer>> attFlowingList = new ArrayList<Map<Date, Integer>>();
		for (long d = beginDate.getTime(); d < date.getTime(); d = Tools
				.addDay(new Date(d)).getTime()) {
			Date temp = new Date(d);
			boolean exsits = false;
			for (Attendanceflowing af : list) {
				if (new SimpleDateFormat("yyyy-MM-dd").format(af.getBegintime()).equals(new SimpleDateFormat("yyyy-MM-dd").format(temp))) {
					exsits = true;
					Map<Date, Integer> map = new HashMap<Date, Integer>();
					map.put(af.getBegintime(), af.getState());// 状态与时间对应
					attFlowingList.add(map);
					break;
				}
			}
			if (exsits == false) {
				Map<Date, Integer> map = new HashMap<Date, Integer>();
				int day = temp.getDay();
				if (day != 6 && day != 7) {
					map.put(temp, Tools.ATTENDANCE_ABS);
				} 
				attFlowingList.add(map);
			}
		}
		// 更改奖惩表
		for(Map<Date, Integer> stateMap:attFlowingList){
			for(Map.Entry<Date, Integer> entry:stateMap.entrySet()){
				writeRewardsandpunishments(entry.getValue(), employeeId, entry.getKey());
			}
		}
	}

}
