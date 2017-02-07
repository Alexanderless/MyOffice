package com.beifeng.dao.dom;

import java.util.List;

import com.beifeng.model.AccessoryFile;

public interface AccessoryFileDao {
	/*
	 * ����FileId��ѯAccessoryFile
	 */
	List<AccessoryFile> queryByFiledid(Integer fileId);
	
	/*
	 * ���FileInfoDao�ĸ�����Ϣ
	 */
	void addAcessory(AccessoryFile accessoryFile);
	
	/**
	 * ɾ������
	 * @param accessoryId
	 */
	void deleteAccessoryFile(Integer accessoryId);

}
