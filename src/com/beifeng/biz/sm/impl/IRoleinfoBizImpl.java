package com.beifeng.biz.sm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.sm.IRoleinfoBiz;
import com.beifeng.dao.sm.RoleinfoDao;
import com.beifeng.model.RoleInfo;
@Service
public class IRoleinfoBizImpl implements IRoleinfoBiz{
	@Autowired
	private RoleinfoDao roleinfoDao;

	//查询所有的角色信息
	public List<RoleInfo> query() {
		// TODO Auto-generated method stub
		return roleinfoDao.query();
	}
	/*
	 * 更改角色
	 * @see com.beifeng.biz.sm.IRoleinfoBiz#update(com.beifeng.model.Roleinfo)
	 */
	@Override
	public void update(RoleInfo roleinfo) {
		roleinfoDao.update(roleinfo);
		
	}
	/*
	 * 更改角色
	 * @see com.beifeng.biz.sm.IRoleinfoBiz#update(com.beifeng.model.Roleinfo)
	 */

	/*
	 * 根据roleId查询角色
	 * @see com.beifeng.biz.sm.IRoleinfoBiz#queryByroleId(java.lang.Integer)
	 */

	@Override
	public RoleInfo queryByroleId(Integer roleId) {
		// TODO Auto-generated method stub
		return roleinfoDao.queryByroleId(roleId);
	}

}
