package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.PageSchedule;
import com.beifeng.model.Schedule;

public interface IScheduleDaocg {

	//�鿴�����ճ�
	List<Schedule> queryScheduleListByName(String userId);
	//��ҳ��ʾ�����ճ�
	List<Schedule> queryPageSchedule(PageSchedule pageSchedule);
	//��Ӹ����ճ�
	void addScheduleList(Schedule schedule);
	//����scheduleId ��ѯ�ճ�
	Schedule queryScheduleById(Integer scheduleId);
	//����ScheduleId�޸�Schedule
	void updateSchedule(Schedule schedule);
	//����ScheduleIdɾ��Schedule
	void delSchedule(Integer scheduleId);
	//���ݴ����ߺ��������Ų�ѯ�����ճ�
	List<Schedule> queryScheduleByMany(Schedule schedule);
	
}
