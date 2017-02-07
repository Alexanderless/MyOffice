package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.PageSchedule;
import com.beifeng.model.Schedule;

public interface IScheduleBizcg {
	
	//��ѯ�����ճ�
	List<Schedule> query(String userId);	
	//��Ӹ����ճ�
	void addScheduleList(Schedule schedule);
	//����scheduleId��ѯ�ճ�
	Schedule queryScheduleById(Integer scheduleId);
	//����ScheduleId�޸�Schedule
	void updateSchedule(Schedule schedule);
	//����ScheduleIdɾ��Schedule
		void delSchedule(Integer scheduleId);
	//ģ����ѯ�����ճ�
	List<Schedule> queryScheduleByMany(Schedule schedule);	
}
