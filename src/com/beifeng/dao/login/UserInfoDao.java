package com.beifeng.dao.login;

import java.util.List;

import com.beifeng.model.UserInfo;

public interface UserInfoDao {
	//�����û��������룬�����û���¼
	UserInfo queryUserInf(UserInfo UserInfo);
	
	//Ajax���ڵ�¼��֤
	List<UserInfo> getJson(UserInfo UserInfo);
}
