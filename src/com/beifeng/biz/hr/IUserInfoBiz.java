package com.beifeng.biz.hr;

import java.util.List;

import com.beifeng.model.PageUserInfo;
import com.beifeng.model.UserInfo;

public interface IUserInfoBiz {
	//分页查询
	PageUserInfo queryPageUserInfo(PageUserInfo pageUserInfo);
	
	//删除
	void delUserInfo(Integer id);
	
	//添加
	void addUserInfo(UserInfo userInfo);
	
	//通过Id添加
	UserInfo queryUserInfoById(Integer id);
	
	//修改
	void updateUserInfo(UserInfo userInfo);
	
	//查看该部门有多少员工
	List<UserInfo> findUserByDepartId(Integer id);
	
	List<UserInfo> queryUserInfoByIdForJSON(Integer id);
}
