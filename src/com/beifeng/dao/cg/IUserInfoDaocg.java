package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.UserInfo;

public interface IUserInfoDaocg {
	
	//��ѯ�û���Ϣ
	List<UserInfo> queryUserInfo(Integer departId);
	
	
}
