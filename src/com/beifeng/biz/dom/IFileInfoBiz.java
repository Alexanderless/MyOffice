package com.beifeng.biz.dom;

import java.util.List;

import com.beifeng.model.AccessoryFile;
import com.beifeng.model.FileInfo;
import com.beifeng.model.FileTreeNode;
import com.beifeng.model.FileTypeInfo;
import com.beifeng.model.PageUtil;


public interface IFileInfoBiz {

	List<FileInfo> query();
	

	List<FileTreeNode> generateTreeNode();
	

	List<FileInfo> queryBypid(Integer pid);
	

	List<FileInfo> queryRecycle();
	

	void update(Integer ifDelete,Integer fileId);
	
	List<FileInfo> search(FileInfo fileInfo, PageUtil pageUtil);
	
	FileInfo queryByfileId(Integer fileId);
	
	List<AccessoryFile> queryByFiledid(Integer fileId);
	
	void updateFileIn(FileInfo fileInfo);
	
	List<FileTypeInfo> queryFileTypeInfo();
	
	void addAcessory(AccessoryFile accessoryFile);
	
	void deleteAccessoryFile(Integer accessoryId);
	
	void addFileIn(FileInfo fileInfo);
	
	int count();

}
