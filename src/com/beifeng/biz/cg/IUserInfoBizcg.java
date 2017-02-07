package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.UserInfo;

public interface IUserInfoBizcg {
	//查询用户信息
		List<UserInfo> queryUserInfo(Integer departId);
}
