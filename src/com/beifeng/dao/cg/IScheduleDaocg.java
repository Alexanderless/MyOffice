package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.PageSchedule;
import com.beifeng.model.Schedule;

public interface IScheduleDaocg {

	//查看个人日程
	List<Schedule> queryScheduleListByName(String userId);
	//分页显示个人日程
	List<Schedule> queryPageSchedule(PageSchedule pageSchedule);
	//添加个人日程
	void addScheduleList(Schedule schedule);
	//根据scheduleId 查询日程
	Schedule queryScheduleById(Integer scheduleId);
	//根据ScheduleId修改Schedule
	void updateSchedule(Schedule schedule);
	//根据ScheduleId删除Schedule
	void delSchedule(Integer scheduleId);
	//根据创建者和所属部门查询部门日程
	List<Schedule> queryScheduleByMany(Schedule schedule);
	
}
