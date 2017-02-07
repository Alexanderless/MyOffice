package com.beifeng.biz.login.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.login.IUserInfoBiz;
import com.beifeng.dao.login.UserInfoDao;
import com.beifeng.model.UserInfo;
@Service
public class IUserInfoBizDomImpl implements IUserInfoBiz{
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfo query(UserInfo UserInfo) {
		return userInfoDao.queryUserInf(UserInfo);
	}
	
	//ajaxµÇÂ¼ÑéÖ¤
	@Override
	public List<UserInfo> getJson(UserInfo userInfo) {
		List<UserInfo> list = userInfoDao.getJson(userInfo);
		return list;
	}

}
