package com.beifeng.biz.cc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.cc.IManualSignBizcc;
import com.beifeng.dao.cc.IManualSignDaocc;
import com.beifeng.model.ManualSign;

@Service
public class IManualSignBizImplcc implements IManualSignBizcc{
	
	@Autowired
	private IManualSignDaocc iManualSignDao;
	/**
	 * @author candy
	 * @param String Id
	 * @return ManualSign
	 * ����signId ��ѯǩ������
	 * 
	*/
	@Override
	public ManualSign queryManByUserId(Integer signId) {
		
		return iManualSignDao.queryManByUserId(signId);
	}
	
	/**
	 * @author candy
	 * @param ManualSign
	 * ��������
	 * 
	*/
	@Override
	public void insertManualSign(ManualSign manualSign) {
		iManualSignDao.insertManualSign(manualSign);
		
	}
	
}
