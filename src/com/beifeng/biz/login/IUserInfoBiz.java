package com.beifeng.biz.login;

import java.util.List;

import com.beifeng.model.UserInfo;

public interface IUserInfoBiz {
	UserInfo query(UserInfo UserInfo);
	
	//Ajax���ڵ�¼��֤
	List<UserInfo> getJson(UserInfo UserInfo);
}
