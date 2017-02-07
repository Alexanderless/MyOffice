package com.beifeng.biz.cg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.cg.IScheduleBizcg;
import com.beifeng.dao.cg.IScheduleDaocg;
import com.beifeng.model.PageSchedule;
import com.beifeng.model.Schedule;

@Service
public class IScheduleBizImplcg implements IScheduleBizcg{
	
	@Autowired
	private IScheduleDaocg iScheduleDao;
	
	//查询个人所有日程
	@Override
	public List<Schedule> query(String userId ) {
		List<Schedule> list=iScheduleDao.queryScheduleListByName(userId);
		return list;
		
	}
	
	//添加日程
	@Override
	public void addScheduleList(Schedule schedule) {
		iScheduleDao.addScheduleList(schedule);
		
	}
	//根据scheduleId 查询日程
	@Override
	public Schedule queryScheduleById(Integer scheduleId) {
		
		return iScheduleDao.queryScheduleById(scheduleId);
	}
	//根据scheduleId修改日程
	@Override
	public void updateSchedule(Schedule schedule) {
		iScheduleDao.updateSchedule(schedule);
		
	}
	//删除日程
	@Override
	public void delSchedule(Integer scheduleId) {
		iScheduleDao.delSchedule(scheduleId);
		
	}
	/**
	 * 
	 *根据机构  部门  或者姓名 或者日期查询 日程 
	 * 
	*/
	public List<Schedule> queryScheduleByMany(Schedule schedule) {
		System.out.println("**************"+schedule);
		return iScheduleDao.queryScheduleByMany(schedule);
	}
	
	
	
	


}
