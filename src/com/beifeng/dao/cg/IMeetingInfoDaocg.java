package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.MeetingInfo;

public interface IMeetingInfoDaocg {
	
	//���ݻ������ֲ��һ���
	MeetingInfo queryMeetInfoByName(String meetingName);
	//�������л���
	List<MeetingInfo> queryMeetInfo();
	
}
