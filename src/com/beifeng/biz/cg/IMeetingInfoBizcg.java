package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.MeetingInfo;

public interface IMeetingInfoBizcg {
	//根据会议名字查找会议
	MeetingInfo queryMeetInfoByName(String meetingName);
	//查找所有会议
	List<MeetingInfo> queryMeetInfo();
}
