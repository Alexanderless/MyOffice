package com.beifeng.dao.dom;

import java.util.List;

import com.beifeng.model.AccessoryFile;

public interface AccessoryFileDao {
	/*
	 * 根据FileId查询AccessoryFile
	 */
	List<AccessoryFile> queryByFiledid(Integer fileId);
	
	/*
	 * 添加FileInfoDao的附件信息
	 */
	void addAcessory(AccessoryFile accessoryFile);
	
	/**
	 * 删除附件
	 * @param accessoryId
	 */
	void deleteAccessoryFile(Integer accessoryId);

}
