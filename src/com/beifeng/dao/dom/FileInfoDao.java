package com.beifeng.dao.dom;

import java.util.List;
import java.util.Map;

import com.beifeng.model.FileInfo;

public interface FileInfoDao {
	/*
	 * 查询信息条数
	 */
	int count();
	/*
	 * 查询所有的的文件信息
	 */
	List<FileInfo> query();
	
	/*
	 * 根据fileId查询某一文件夹
	 */
	FileInfo queryByfileId(Integer fileId);
	
	/*
	 * 根据pid查询文件夹下的所有子文件
	 */
	List<FileInfo> queryBypid(Integer pid);
	
	/*
	 * 更改文件的ifDelete属性
	 */
	void update(FileInfo fileInfo);
	
	/*
	 * 检索文件
	 */
	List<FileInfo> search(Map<String, Object> map);
	
	/*
	 * 添加文件
	 */
	void addFileIn(FileInfo fileInfo);
	
	/*
	 * 保存修改的文件信息
	 */
	void updateFileIn(FileInfo fileInfo);

}
