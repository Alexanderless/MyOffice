package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.UserInfo;

public interface IUserInfoBizcg {
	//��ѯ�û���Ϣ
		List<UserInfo> queryUserInfo(Integer departId);
}
