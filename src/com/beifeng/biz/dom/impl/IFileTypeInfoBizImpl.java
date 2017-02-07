package com.beifeng.biz.dom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.dom.IFileTypeInfoBiz;
import com.beifeng.dao.dom.FileTypeInfoDao;
import com.beifeng.model.FileTypeInfo;
@Service
public class IFileTypeInfoBizImpl implements IFileTypeInfoBiz{

	@Autowired
	private FileTypeInfoDao fileTypeInfoDao;
	@Override
	public List<FileTypeInfo> queryFileTypeInfo() {
		return fileTypeInfoDao.queryFileTypeInfo();
	}

}
