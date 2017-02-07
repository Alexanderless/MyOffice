package com.beifeng.biz.dom.impl;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.dom.IFileInfoBiz;
import com.beifeng.dao.dom.AccessoryFileDao;
import com.beifeng.dao.dom.FileInfoDao;
import com.beifeng.dao.dom.FileTypeInfoDao;
import com.beifeng.model.AccessoryFile;
import com.beifeng.model.FileInfo;
import com.beifeng.model.FileTreeNode;
import com.beifeng.model.FileTypeInfo;
import com.beifeng.model.PageUtil;

@Service
public class IFileInfoBizImpl implements IFileInfoBiz{
	@Autowired
	private FileTypeInfoDao fileTypeInfoDao;
	@Autowired
	private FileInfoDao fileInfoDao;
	@Autowired
	private AccessoryFileDao accessoryFileDao;
	
	/*
	 * 查询文件所有信息
	 * (non-Javadoc)
	 * @see com.beifeng.biz.IFileInfoBiz#query()
	 */
	@Override
	public List<FileInfo> query() {
		return fileInfoDao.query();
		
	}
	/*
	 * 树形递归
	 * (non-Javadoc)
	 * @see com.beifeng.biz.IFileInfoBiz#generateTreeNode()
	 */
	@Override
	public List<FileTreeNode> generateTreeNode() {
		List<FileTreeNode> list1=new ArrayList<FileTreeNode>();
		List<FileInfo> list=fileInfoDao.query();
		for (FileInfo fileInfo : list) {
			//删选掉删除的
			if(fileInfo.getIfDelete()==2){
				FileTreeNode fileTreeNode=new FileTreeNode();
				fileTreeNode.setId(fileInfo.getFileId());
				fileTreeNode.setName(fileInfo.getFileName());
				fileTreeNode.setpId(fileInfo.getParentId());
				fileTreeNode.setOpen(false);
				fileTreeNode.setFile("queryBypid.do?id="+fileInfo.getFileId());
				list1.add(fileTreeNode);
			}
		}
		return list1;
		
	}

	/*
	 * 查询某一文件夹下的所有子文件
	 */
	@Override
	public List<FileInfo> queryBypid(Integer pid) {
		List<FileInfo> list=new ArrayList<FileInfo>();
		List<FileInfo> list1=fileInfoDao.queryBypid(pid);
		for (FileInfo fileInfo : list1) {
			if(fileInfo.getIfDelete()==2){
				list.add(fileInfo);
			}
		}
		return list;
	}
	
	
	/*
	 * 查看回收站的所有文件
	 */	
	public List<FileInfo> queryRecycle() {
		List<FileInfo> list1=new ArrayList<FileInfo>();
		List<FileInfo> list=fileInfoDao.query();
		for (FileInfo fileInfo : list) {
			if(fileInfo.getIfDelete()==1){
				list1.add(fileInfo);
			}
		}
		return list1;
	}
	

	/*
	 * 修改文件的状态：删除，还原
	 */
	@Override
	public void update(Integer ifDelete, Integer fileId) {
		FileInfo fileInfo=new FileInfo();
		fileInfo.setFileId(fileId);
		fileInfo.setIfDelete(ifDelete);
		fileInfoDao.update(fileInfo);
	}

	/*
	 * 检索文件
	 * (non-Javadoc)
	 * @see com.beifeng.biz.IFileInfoBiz#search(com.beifeng.model.FileInfo)
	 */
	@Override
	public List<FileInfo> search(FileInfo fileInfo, PageUtil pageUtil) {
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("pageUtil", pageUtil);
		map.put("fileInfo", fileInfo);
		return fileInfoDao.search(map);
	}
	/*
	 * 查询文件为fileId的文件
	 */

	@Override
	public FileInfo queryByfileId(Integer fileId) {
		
		return fileInfoDao.queryByfileId(fileId);
	}
	
	/*
	 * 查询文件附件信息
	 * (non-Javadoc)
	 * @see com.beifeng.biz.IFileInfoBiz#queryByFiledid(java.lang.Integer)
	 */
	@Override
	public List<AccessoryFile> queryByFiledid(Integer fileId) {
		return accessoryFileDao.queryByFiledid(fileId);
	}
	
	/*
	 * 文件夹下添加文件
	 * (non-Javadoc)
	 * @see com.beifeng.biz.dom.IFileInfoBiz#addFileIn(com.beifeng.model.FileInfo)
	 */
	@Override
	public void addFileIn(FileInfo fileInfo) {
		fileInfoDao.addFileIn(fileInfo);
		
	}	 
	
	@Override
	/*
	 *更改修改的文件信息
	 * @see com.beifeng.biz.dom.IFileInfoBiz#updateFileIn(com.beifeng.model.FileInfo)
	 */
	
	public void updateFileIn(FileInfo fileInfo) {
		fileInfoDao.updateFileIn(fileInfo);
		
	}
	@Override
	/**
	 * 查询全部文件类型
	 */
	public List<FileTypeInfo> queryFileTypeInfo() {
		// TODO Auto-generated method stub
		return fileTypeInfoDao.queryFileTypeInfo();
	}
	
	/*
	 * 添加附件时，添加附件信息
	 * @see com.beifeng.biz.dom.IFileInfoBiz#addAcessory(com.beifeng.model.AccessoryFile)
	 */
	@Override
	public void addAcessory(AccessoryFile accessoryFile) {
		accessoryFileDao.addAcessory(accessoryFile);
		
	}
	
	/**
	 * 删除附件信息
	 */
	@Override
	public void deleteAccessoryFile(Integer accessoryId) {
		accessoryFileDao.deleteAccessoryFile(accessoryId);
		
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return fileInfoDao.count();
	}

	
	
}
