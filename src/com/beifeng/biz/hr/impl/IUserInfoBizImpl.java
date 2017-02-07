package com.beifeng.biz.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.hr.IUserInfoBiz;
import com.beifeng.dao.hr.IUserInfoDao;
import com.beifeng.model.PageUserInfo;
import com.beifeng.model.UserInfo;
@Service
public class IUserInfoBizImpl implements IUserInfoBiz{
	@Autowired
	private IUserInfoDao iUserInfoDao;
	
	/*
	 * 显示分页
	 */
	@Override
	public PageUserInfo queryPageUserInfo(PageUserInfo pageUserInfo) {
		List<UserInfo> list = iUserInfoDao.queryPageUserInfo(pageUserInfo);
		PageUserInfo pu = new PageUserInfo();
		pu.setCurrentPage(pageUserInfo.getCurrentPage());
		pu.setPageRecords(pageUserInfo.getPageRecords());
		pu.setList(list);
		List<UserInfo> listUser = iUserInfoDao.queryUserInfo();
		pu.setTotalRecords(listUser.size());
		return pu;
	}
	
	/*
	 * 删除(non-Javadoc)
	 * @see com.beifeng.biz.IUserInfoBiz#delUserInfo(java.lang.Integer)
	 */
	@Override
	public void delUserInfo(Integer id) {
		iUserInfoDao.delUserINfo(id);
	}
	
	/*
	 * 添加(non-Javadoc)
	 * @see com.beifeng.biz.IUserInfoBiz#addUserInfo(com.beifeng.model.UserInfo)
	 */
	@Override
	public void addUserInfo(UserInfo userInfo) {
		iUserInfoDao.addUserInfo(userInfo);
	}
	

	/*
	 * 通过Id查找UserInfo
	 */
	@Override
	public UserInfo queryUserInfoById(Integer id) {
		UserInfo userInfo = iUserInfoDao.queryUserInfoById(id);
		return userInfo;
	}
	
	/*
	 * 修改(non-Javadoc)
	 * @see com.beifeng.biz.IUserInfoBiz#updateUserInfo(com.beifeng.model.UserInfo)
	 */
	@Override
	public void updateUserInfo(UserInfo userInfo) {
		iUserInfoDao.updateUserInfo(userInfo);
	}

	@Override
	public List<UserInfo> findUserByDepartId(Integer id) {
		List<UserInfo> list = iUserInfoDao.findUserByDepartId(id);
		return list;
	}

	@Override
	public List<UserInfo> queryUserInfoByIdForJSON(Integer id) {
		List<UserInfo> list = iUserInfoDao.queryUserInfoByIdForJSON(id);
		return list;
	}
	
	

}
