package com.beifeng.model;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class FileInfo {
	private Integer fileId;
	private String fileName;
	private FileTypeInfo fileTypeInfo;
	private String remark;
	private String fileOwner;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	private Integer parentId;
	private String filePath;
	private Integer ifDelete=2;


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileTypeInfo getFileTypeInfo() {
		return fileTypeInfo;
	}

	public void setFileTypeInfo(FileTypeInfo fileTypeInfo) {
		this.fileTypeInfo = fileTypeInfo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFileOwner() {
		return fileOwner;
	}

	public void setFileOwner(String fileOwner) {
		this.fileOwner = fileOwner;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getIfDelete() {
		return ifDelete;
	}

	public void setIfDelete(Integer ifDelete) {
		this.ifDelete = ifDelete;
	}

	@Override
	public String toString() {
		return "FileInfo [fileId=" + fileId + ", fileName=" + fileName
				+ ", fileTypeInfo=" + fileTypeInfo + ", remark=" + remark
				+ ", fileOwner=" + fileOwner + ", createDate=" + createDate
				+ ", parentId=" + parentId + ", filePath=" + filePath
				+ ", ifDelete=" + ifDelete + "]";
	}

	
	
}
