package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.MeetingInfo;

public interface IMeetingInfoBizcg {
	//���ݻ������ֲ��һ���
	MeetingInfo queryMeetInfoByName(String meetingName);
	//�������л���
	List<MeetingInfo> queryMeetInfo();
}
