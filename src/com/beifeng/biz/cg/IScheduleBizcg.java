package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.PageSchedule;
import com.beifeng.model.Schedule;

public interface IScheduleBizcg {
	
	//查询个人日程
	List<Schedule> query(String userId);	
	//添加个人日程
	void addScheduleList(Schedule schedule);
	//根据scheduleId查询日程
	Schedule queryScheduleById(Integer scheduleId);
	//根据ScheduleId修改Schedule
	void updateSchedule(Schedule schedule);
	//根据ScheduleId删除Schedule
		void delSchedule(Integer scheduleId);
	//模糊查询部门日程
	List<Schedule> queryScheduleByMany(Schedule schedule);	
}
