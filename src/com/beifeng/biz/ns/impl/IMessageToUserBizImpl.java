package com.beifeng.biz.ns.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.ns.IMessageToUserBiz;
import com.beifeng.dao.ns.IMessageToUserDao;
import com.beifeng.model.MessageToUser;

@Service
public class IMessageToUserBizImpl implements IMessageToUserBiz  {
	@Autowired
	private IMessageToUserDao iMessageToUserDao;
	
	@Override
	public MessageToUser queryMessageToUser(Integer id) {
		MessageToUser messageTouser = iMessageToUserDao.queryMessageToUser(id);
		return messageTouser;
	}

	@Override
	public void delMessagetouser(Integer id) {
		iMessageToUserDao.delMessagetouser(id);		
	}
	/*
	 *�޸��Ƿ��Ѷ�
	 */
	@Override
	public void updateIfread(Integer id) {
		iMessageToUserDao.updateIfread(id);	
	}	
}
