package com.beifeng.biz.sm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.sm.ILoginlogBiz;
import com.beifeng.dao.sm.LoginlogDao;
import com.beifeng.model.Loginlog;
import com.beifeng.model.Time;
@Service
public class ILoginlogBizImpl implements ILoginlogBiz{
	@Autowired
	private LoginlogDao loginlogDao;

	@Override
	public List<Loginlog> query(Time time) {
		return loginlogDao.query(time);
	}

	@Override
	public void delete(int[] ids) {
		loginlogDao.delete(ids);

	}
}
