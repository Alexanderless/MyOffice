package com.beifeng.dao.dom;

import java.util.List;
import java.util.Map;

import com.beifeng.model.FileInfo;

public interface FileInfoDao {
	/*
	 * ��ѯ��Ϣ����
	 */
	int count();
	/*
	 * ��ѯ���еĵ��ļ���Ϣ
	 */
	List<FileInfo> query();
	
	/*
	 * ����fileId��ѯĳһ�ļ���
	 */
	FileInfo queryByfileId(Integer fileId);
	
	/*
	 * ����pid��ѯ�ļ����µ��������ļ�
	 */
	List<FileInfo> queryBypid(Integer pid);
	
	/*
	 * �����ļ���ifDelete����
	 */
	void update(FileInfo fileInfo);
	
	/*
	 * �����ļ�
	 */
	List<FileInfo> search(Map<String, Object> map);
	
	/*
	 * ����ļ�
	 */
	void addFileIn(FileInfo fileInfo);
	
	/*
	 * �����޸ĵ��ļ���Ϣ
	 */
	void updateFileIn(FileInfo fileInfo);

}
