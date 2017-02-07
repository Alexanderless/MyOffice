package com.beifeng.biz.hr;

import java.util.List;

import com.beifeng.model.PageUserInfo;
import com.beifeng.model.UserInfo;

public interface IUserInfoBiz {
	//��ҳ��ѯ
	PageUserInfo queryPageUserInfo(PageUserInfo pageUserInfo);
	
	//ɾ��
	void delUserInfo(Integer id);
	
	//����
	void addUserInfo(UserInfo userInfo);
	
	//ͨ��Id����
	UserInfo queryUserInfoById(Integer id);
	
	//�޸�
	void updateUserInfo(UserInfo userInfo);
	
	//�鿴�ò����ж���Ա��
	List<UserInfo> findUserByDepartId(Integer id);
	
	List<UserInfo> queryUserInfoByIdForJSON(Integer id);
}