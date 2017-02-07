package com.beifeng.biz.dom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.dom.IAccessoryFileBiz;
import com.beifeng.dao.dom.AccessoryFileDao;
import com.beifeng.model.AccessoryFile;
@Service
public class IAccessoryFileBizImpl implements IAccessoryFileBiz {
	@Autowired
	private AccessoryFileDao accessoryFileDao;

	@Override
	public List<AccessoryFile> queryByFiledid(Integer fileId) {
		return accessoryFileDao.queryByFiledid(11);
	}
	

}
