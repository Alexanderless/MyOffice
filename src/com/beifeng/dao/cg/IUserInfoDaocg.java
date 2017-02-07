package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.UserInfo;

public interface IUserInfoDaocg {
	
	//查询用户信息
	List<UserInfo> queryUserInfo(Integer departId);
	
	
}
