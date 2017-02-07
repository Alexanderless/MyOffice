package com.beifeng.biz.cg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.cg.IMeetingInfoBizcg;
import com.beifeng.dao.cg.IMeetingInfoDaocg;
import com.beifeng.model.MeetingInfo;
@Service
public class IMeetingInfoBizImplcg implements IMeetingInfoBizcg{
	//�������Ʋ��һ���
	@Autowired
	private IMeetingInfoDaocg iMeetingInfoDao;
	@Override
	public MeetingInfo queryMeetInfoByName(String meetingName) {
		
		return iMeetingInfoDao.queryMeetInfoByName(meetingName);
	}
	//�������л���
	@Override
	public List<MeetingInfo> queryMeetInfo() {
		
		return iMeetingInfoDao.queryMeetInfo();
	}

}
