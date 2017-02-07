package com.beifeng.biz.sm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.sm.IOperateLogBiz;
import com.beifeng.dao.sm.OperateLogDao;
import com.beifeng.model.OperateLog;
import com.beifeng.model.Time;
@Service
public class IOperateLogBizImpl implements IOperateLogBiz{
	@Autowired
	private OperateLogDao operateLogDao;

	@Override
	public List<OperateLog> searchOpe(Time time) {
		// TODO Auto-generated method stub
		return operateLogDao.searchOpe(time);
	}

	@Override
	public void delete(int[] ids) {
		operateLogDao.delete(ids);
		
	}



}
