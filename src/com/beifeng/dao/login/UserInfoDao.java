package com.beifeng.dao.login;

import java.util.List;

import com.beifeng.model.UserInfo;

public interface UserInfoDao {
	//根据用户名和密码，用于用户登录
	UserInfo queryUserInf(UserInfo UserInfo);
	
	//Ajax用于登录验证
	List<UserInfo> getJson(UserInfo UserInfo);
}
