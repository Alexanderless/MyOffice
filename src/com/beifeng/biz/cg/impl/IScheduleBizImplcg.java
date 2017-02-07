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
	
	//��ѯ���������ճ�
	@Override
	public List<Schedule> query(String userId ) {
		List<Schedule> list=iScheduleDao.queryScheduleListByName(userId);
		return list;
		
	}
	
	//����ճ�
	@Override
	public void addScheduleList(Schedule schedule) {
		iScheduleDao.addScheduleList(schedule);
		
	}
	//����scheduleId ��ѯ�ճ�
	@Override
	public Schedule queryScheduleById(Integer scheduleId) {
		
		return iScheduleDao.queryScheduleById(scheduleId);
	}
	//����scheduleId�޸��ճ�
	@Override
	public void updateSchedule(Schedule schedule) {
		iScheduleDao.updateSchedule(schedule);
		
	}
	//ɾ���ճ�
	@Override
	public void delSchedule(Integer scheduleId) {
		iScheduleDao.delSchedule(scheduleId);
		
	}
	/**
	 * 
	 *���ݻ���  ����  �������� �������ڲ�ѯ �ճ� 
	 * 
	*/
	public List<Schedule> queryScheduleByMany(Schedule schedule) {
		System.out.println("**************"+schedule);
		return iScheduleDao.queryScheduleByMany(schedule);
	}
	
	
	
	


}
