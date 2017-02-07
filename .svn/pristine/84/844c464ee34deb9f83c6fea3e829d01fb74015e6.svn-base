package com.beifeng.biz.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.hr.IRoleAndStateBiz;
import com.beifeng.dao.hr.IRoleAndStateDao;
import com.beifeng.model.RoleInfo;
import com.beifeng.model.UserState;
@Service
public class IRoleAndStateBizImpl implements IRoleAndStateBiz {
	@Autowired
	private IRoleAndStateDao iRoleAndStateDao;
	
	//≤È—ØRoleInfo
	@Override
	public List<RoleInfo> queryRole() {
		List<RoleInfo> listRole = iRoleAndStateDao.queryRole();
		return listRole;
	}
	//≤È—ØUserState
	@Override
	public List<UserState> queryUserState() {
		List<UserState> listUser = iRoleAndStateDao.queryUserState();
		return listUser;
	}
	
}
