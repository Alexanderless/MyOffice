package com.beifeng.dao.hr;

import java.util.List;

import com.beifeng.model.PageUserInfo;
import com.beifeng.model.UserInfo;

public interface IUserInfoDao {
	//��ѯȫ��
	List<UserInfo> queryUserInfo();
	
	//��ҳ��ѯ
	List<UserInfo> queryPageUserInfo(PageUserInfo pageUserInfo);
	
	//ɾ��
	void delUserINfo(Integer id);
	
	//����
	void addUserInfo(UserInfo userInfo);
	
	//ͨ��id����UserInfo
	UserInfo queryUserInfoById(Integer id);
	
	List<UserInfo> queryUserInfoByIdForJSON(Integer id);
	
	//�޸�
	void updateUserInfo(UserInfo userInfo);
	
	//�鿴�ĸ������ж���Ա��
	List<UserInfo> findUserByDepartId(Integer id);
}