package com.beifeng.biz.cg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.cg.IUserInfoBizcg;
import com.beifeng.dao.cg.IUserInfoDaocg;
import com.beifeng.model.UserInfo;
@Service
public class IUserInfoBizImplcg implements IUserInfoBizcg{
		
	@Autowired
	private IUserInfoDaocg iUserInfoDao;
	@Override
	public List<UserInfo> queryUserInfo(Integer departId) {
		
		return iUserInfoDao.queryUserInfo(departId);
	}

}
