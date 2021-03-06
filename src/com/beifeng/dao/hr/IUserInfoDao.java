package com.beifeng.dao.hr;

import java.util.List;

import com.beifeng.model.PageUserInfo;
import com.beifeng.model.UserInfo;

public interface IUserInfoDao {
	//查询全部
	List<UserInfo> queryUserInfo();
	
	//分页查询
	List<UserInfo> queryPageUserInfo(PageUserInfo pageUserInfo);
	
	//删除
	void delUserINfo(Integer id);
	
	//添加
	void addUserInfo(UserInfo userInfo);
	
	//通过id查找UserInfo
	UserInfo queryUserInfoById(Integer id);
	
	List<UserInfo> queryUserInfoByIdForJSON(Integer id);
	
	//修改
	void updateUserInfo(UserInfo userInfo);
	
	//查看哪个部门有多少员工
	List<UserInfo> findUserByDepartId(Integer id);
}
